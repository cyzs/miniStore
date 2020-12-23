package com.example.hxsp.dao;

import com.example.hxsp.bean.OrderProduct;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductDao {

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
