package com.example.hxsp.service;

import com.example.hxsp.bean.OrderInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderInfoService {
    /**
     * 添加订单
     */
    void add(OrderInfo orderInfo);


    /**
     * 查询订单
     * @param
     * @return
     */
    Map<String,Object> selOrder(Integer pageNo, Integer pageSize, Integer uid, String realName, Integer status, Integer refundStatus,Integer paid);



    /**
     * 用户删除订单
     * @param id
     * @return
     */
    void userDel(Integer id);

    /**
     * 管理员删除订单
     * @param id
     */
    void adminDel(Integer id);

    /**
     * 支付成功
     * @param orderId 订单号
     */
    void sucPaid(String orderId);

    /**
     * 发货
     * @param orderId 订单号
     * @param deliveryName 快递名称
     * @param deliveryType 发货类型
     * @param deliveryId  快递单号
     */
    void deliverGoods(String orderId,String deliveryName,String deliveryType,String deliveryId);

    /**
     * 申请退款
     * @param orderId 订单号
     * @param refundReasonWapImg 退款图片
     * @param refundReasonWapExplain 退款用户说明
     * @param refundReasonWap 前台退款原因
     */
    void refund(String orderId,String refundReasonWapImg,String refundReasonWapExplain,String refundReasonWap);

    /**
     * 同意退款
     * @param orderId 订单号
     */
    void agreeRefund(String orderId);

    /**
     * 拒绝退款
     * @param orderId 订单号
     * @param refundReason 不退款理由
     */
    void refusedRefund(String orderId,String refundReason);

    /**
     * 确认收货,发放积分
     * @param orderId 订单号
     */
    void confirmTheGoods(String orderId);

    /**
     * 根据订单号查询订单信息
     * @param orderId
     */
    OrderInfo orderInfos(String orderId);


}
