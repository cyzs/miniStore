package com.example.hxsp.service.impl;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.OrderInfo;
import com.example.hxsp.bean.UserInfo;
import com.example.hxsp.dao.OrderInfoDao;
import com.example.hxsp.dao.UserInfoDao;
import com.example.hxsp.service.OrderInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public void add(OrderInfo orderInfo) {
        orderInfoDao.add(orderInfo);
    }

    @Override
    public Map<String,Object> selOrder(Integer pageNo, Integer pageSize,Integer uid,String realName,Integer status,Integer refundStatus,Integer paid) {
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setUid(uid);
        orderInfo.setRealName(realName);
        orderInfo.setStatus(status);
        orderInfo.setRefundStatus(refundStatus);
        orderInfo.setPaid(paid);

        Map<String, Object> map = new HashMap<>(2);
        PageHelper.startPage(pageNo, pageSize);
        List<OrderInfo> list = orderInfoDao.selOrder(orderInfo);
        PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(list);

        List<OrderInfo> list2 = pageInfo.getList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        map.put("list",dateFormat(list2));
        map.put("total", pageInfo.getTotal());
        return map;
    }


    @Override
    public void userDel(Integer id) {
        orderInfoDao.userDel(id);
    }

    @Override
    public void adminDel(Integer id) {
        orderInfoDao.adminDel(id);
    }

    @Override
    public void sucPaid(String orderId) {
        orderInfoDao.sucPaid(orderId,new Date());

    }

    @Override
    public void deliverGoods(String orderId, String deliveryName, String deliveryType, String deliveryId) {
        orderInfoDao.deliverGoods(orderId,deliveryName,deliveryType,deliveryId);
    }

    @Override
    public void refund(String orderId, String refundReasonWapImg, String refundReasonWapExplain, String refundReasonWap) {
        orderInfoDao.refund(orderId,refundReasonWapImg,refundReasonWapExplain,refundReasonWap);
        //未发货则直接退款(未写)
        OrderInfo orderInfo=orderInfoDao.orderInfos(orderId);
        Date refundReasonTime=new Date();
        orderInfoDao.agreeRefund(orderId,refundReasonTime,orderInfo.getPayPrice(),orderInfo.getUseIntegral());
    }

    @Override
    public void agreeRefund(String orderId) {
        OrderInfo orderInfo=orderInfoDao.orderInfos(orderId);
        Date refundReasonTime=new Date();
        orderInfoDao.agreeRefund(orderId,refundReasonTime,orderInfo.getPayPrice(),orderInfo.getUseIntegral());
    }

    @Override
    public void refusedRefund(String orderId, String refundReason) {
        orderInfoDao.refusedRefund(orderId,refundReason);
    }

    @Override
    public void confirmTheGoods(String orderId) {
        //确认收货
        orderInfoDao.confirmTheGoods(orderId);
        //------- 增加积分 ------------
        //查询该订单可获得的积分数
        OrderInfo orderInfo=orderInfoDao.orderInfos(orderId);
        Integer gainIntegral= orderInfo.getGainIntegral();
        userInfoDao.modifyIntegral(orderInfo.getUid(),gainIntegral);
    }

    @Override
    public OrderInfo orderInfos(String orderId) {
        return orderInfoDao.orderInfos(orderId);
    }


    /**
     * 日期格式轉換
     * @param list
     * @return
     */
    public List<OrderInfo> dateFormat(List<OrderInfo> list){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (OrderInfo orderInfo : list) {
            try {


                Date uet = orderInfo.getCreateTime();
                Date ust = orderInfo.getPayTime();
                Date ret = orderInfo.getRefundReasonTime();
                Date upt =orderInfo.getUpdateTime();
                if (upt!=null){
                    orderInfo.setUpdateTime(sdf.parse(sdf.format(upt)));
                }

                if(uet!=null) {
                    orderInfo.setCreateTime(sdf.parse(sdf.format(orderInfo.getCreateTime())));
                }
                if(ust!=null) {
                    orderInfo.setPayTime(sdf.parse(sdf.format(orderInfo.getPayTime())));
                }
                if(ret!=null) {
                    orderInfo.setRefundReasonTime(sdf.parse(sdf.format(orderInfo.getRefundReasonTime())));
                }
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }
        }
        return list;
    }
}
