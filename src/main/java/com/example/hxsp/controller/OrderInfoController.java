package com.example.hxsp.controller;

import com.alibaba.fastjson.JSON;
import com.example.hxsp.bean.OrderInfo;
import com.example.hxsp.bean.OrderProduct;
import com.example.hxsp.bean.ProductInfo;
import com.example.hxsp.bean.UserInfo;
import com.example.hxsp.service.OrderInfoService;
import com.example.hxsp.service.OrderProductService;
import com.example.hxsp.service.UserInfoService;
import com.example.hxsp.utils.OrderNumUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.hxsp.utils.JsonResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;



/**
 * 订单表:
 * 增删改查、 卖家发货、买家卖家退款操作、快递查询、卖家改价操作
 * 
 * 
 */
@Slf4j
@RestController
@RequestMapping("hxsp/order")
public class OrderInfoController extends BaseController{

    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询订单
     * @param pageNo
     * @param pageSize
     * @param uid
     * @param realName 用户姓名
     * @param status 订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货，待评价；3：已完成；）
     * @param refundStatus 0 未退款 1 申请中 2 已退款
     * @param paid 支付状态 0未支付 1已支付
     * @return
     */
    @RequestMapping("/selOrder")
    public JsonResult<Map<String, Object>> selOrder(Integer pageNo, Integer pageSize, Integer uid, String realName, Integer status, Integer refundStatus,Integer paid){

        return new JsonResult<Map<String, Object>>(SUCCESS,orderInfoService.selOrder(pageNo, pageSize, uid, realName, status, refundStatus,paid));
    }

    /**
     * 添加订单
     * @param uid 用户id
     * @param realName 用户姓名
     * @param userPhone 用户电话
     * @param userAddress 详细地址
     * @param orderType 订单类型（1：普通，2：积分）
     * @param totalNum 订单商品总数
     * @param totalPrice 订单总价
     * @param totalPostage 邮费
     * @param payPrice 实际支付金额
     * @param payPostage 支付邮费
     * @param deductionPrice 抵扣金额
     * @param couponId 优惠券id
     * @param couponPrice 优惠券金额
     * @param productList 商品列表
     * @param gainIntegral 消费赚取积分
     * @param useIntegral  使用积分
     * @return
     */
    @RequestMapping("add")
    public JsonResult<Map<String,Object>> add(Integer uid, String realName, String userPhone, String userAddress, Integer orderType, Integer totalNum,
                                String totalPrice, Double totalPostage, String payPrice, String payPostage, String deductionPrice, Integer couponId, String couponPrice,
                                Integer gainIntegral,Integer useIntegral, String productList){
        OrderInfo orderInfo=new OrderInfo();
        //生成订单号
        String orderId= OrderNumUtil.getOrderIdByTime();
        orderInfo.setOrderId(orderId);
        orderInfo.setUid(uid);
        orderInfo.setRealName(realName);
        orderInfo.setUserPhone(userPhone);
        orderInfo.setUserAddress(userAddress);
        orderInfo.setTotalNum(totalNum);

        orderInfo.setTotalPrice(new BigDecimal(totalPrice));
        orderInfo.setTotalPostage(totalPostage);
        orderInfo.setPayPrice(new BigDecimal(payPrice));
        if (payPostage==null||payPostage==""){
            payPostage="0";
        }
        orderInfo.setPayPostage(new BigDecimal(payPostage));
        if (deductionPrice==null||deductionPrice==""){
            deductionPrice="0";
        }
        orderInfo.setDeductionPrice(new BigDecimal(deductionPrice));
        orderInfo.setCouponId(couponId);
        if (couponPrice==null||couponPrice==""){
            couponPrice="0";
        }
        orderInfo.setCouponPrice(new BigDecimal(couponPrice));
        orderInfo.setGainIntegral(gainIntegral);
        orderInfo.setUseIntegral(useIntegral);
        if (orderType==null){
            orderType=1;
        }
        orderInfo.setOrderType(orderType);
        orderInfoService.add(orderInfo);


        //添加订单商品关系表
        List<Map<String,Object>> orderProductList= (List<Map<String,Object>>) JSON.parse(productList);
        for (Map<String,Object> map:orderProductList){
            Integer productId=Integer.valueOf(map.get("id").toString());
            String productName=map.get("productName").toString();
            Integer cartNum=Integer.valueOf(map.get("cartNum").toString());
            String image=map.get("image").toString();
            String price=map.get("price").toString();
            orderProductService.add(orderId,productId,productName,image,price,cartNum);
        }
        Map<String,Object> map=new HashMap<>();
        //如果是积分订单，则支付状态改为已支付
        if (orderType==2){
            //-----扣除用户积分------
            //获取用户积分
            UserInfo userInfo=userInfoService.selUserInfoByUid(uid);
            //剩余积分
            Integer integral=userInfo.getIntegral();
            if (integral-useIntegral>=0){
                //扣除积分
                userInfoService.modifyIntegral(uid,-useIntegral);

                //修改订单状态
                orderInfoService.sucPaid(orderId);
                map.put("code",0);
                map.put("msg","兑换成功");
            }else {
                map.put("code",-1);
                map.put("msg","积分不足");
            }
        }



        map.put("orderId",orderId);

        return new JsonResult<Map<String, Object>>(SUCCESS,map);
    }

    /**
     * 用户删除订单
     * @param id
     * @return
     */
    @RequestMapping("userDel")
    public JsonResult<Void> userDel(Integer id){
        orderInfoService.userDel(id);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 管理员删除订单
     * @param id
     * @return
     */
    @RequestMapping("adminDel")
    public JsonResult<Void> adminDel(Integer id){
        orderInfoService.adminDel(id);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 发货
     * @param orderId 订单号
     * @param deliveryName 快递名称
     * @param deliveryType 发货类型
     * @param deliveryId  快递单号
     */
    @RequestMapping("deliverGoods")
    public JsonResult<Void> deliverGoods(String orderId,String deliveryName,String deliveryType,String deliveryId){
        orderInfoService.deliverGoods(orderId,deliveryName,deliveryType,deliveryId);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 申请退款
     * @param orderId 订单号
     * @param refundReasonWapImg 退款图片
     * @param refundReasonWapExplain 退款用户说明
     * @param refundReasonWap 前台退款原因
     */
    @RequestMapping("refund")
    public JsonResult<Void> refund(String orderId, String refundReasonWapImg, String refundReasonWapExplain, String refundReasonWap) {
        orderInfoService.refund(orderId,refundReasonWapImg,refundReasonWapExplain,refundReasonWap);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 同意退款
     * @param orderId 订单号
     */
    @RequestMapping("agreeRefund")
    public JsonResult<Void> agreeRefund(String orderId) {
        orderInfoService.agreeRefund(orderId);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 拒绝退款
     * @param orderId 订单号
     * @param refundReason 不退款理由
     */
    @RequestMapping("refusedRefund")
    public JsonResult<Void> refusedRefund(String orderId, String refundReason) {
        orderInfoService.refusedRefund(orderId,refundReason);
        return new JsonResult<Void>(SUCCESS);
    }

    /**
     * 确认收货
     * @param orderId
     * @return
     */
    @RequestMapping("confirmTheGoods")
    public JsonResult<Void> confirmTheGoods(String orderId){
        orderInfoService.confirmTheGoods(orderId);
        return new JsonResult<Void>(SUCCESS);
    }

}



