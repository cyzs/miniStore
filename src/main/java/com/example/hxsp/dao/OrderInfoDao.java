package com.example.hxsp.dao;

import com.example.hxsp.bean.OrderInfo;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderInfoDao {

    /**
     * 添加订单
     */
    void add(OrderInfo orderInfo);


    /**
     * 查询订单
     * @param orderInfo
     * @return
     */
    List<OrderInfo> selOrder(OrderInfo orderInfo);

    /**
     * 修改订单
     * @param orderInfo
     */
    void update(OrderInfo orderInfo);

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
     * @param payTime 支付时间
     */
    void sucPaid(String orderId, Date payTime);

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
     * @param refundReasonTime 退款时间
     * @param refundPrice 退款金额
     * @param backIntegral 退还积分数
     */
    void agreeRefund(String orderId, Date refundReasonTime, BigDecimal refundPrice,Integer backIntegral);

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
