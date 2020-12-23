package com.example.hxsp.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单商品关联表
 */
@Data
public class OrderProduct {
    private Integer id;
    private String orderId; //订单号
    private Integer productId; //商品ID
    private String productName;//商品名称
    private String image;  //商品图片
    private String price;  //金额
    private Integer cartNum; //商品数量

}
