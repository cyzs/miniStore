package com.example.hxsp.service;

import com.example.hxsp.bean.OrderProduct;

import java.util.List;

public interface OrderProductService {


    /**
     * 查看订单商品列表
     * @param orderId 订单号
     * @return
     */
    List<OrderProduct> list(Integer orderId);

    /**
     * 添加订单商品关联
     */
    void add(String orderId,Integer productId,String productName,String image,String price,Integer cartNum);

}
