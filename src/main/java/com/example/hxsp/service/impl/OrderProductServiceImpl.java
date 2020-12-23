package com.example.hxsp.service.impl;

import com.example.hxsp.bean.OrderProduct;
import com.example.hxsp.dao.OrderProductDao;
import com.example.hxsp.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public List<OrderProduct> list(Integer orderId) {
        return orderProductDao.list(orderId);
    }

    @Override
    public void add(String orderId,Integer productId,String productName,String image,String price,Integer cartNum) {
        orderProductDao.add( orderId, productId, productName, image, price, cartNum);
    }
}
