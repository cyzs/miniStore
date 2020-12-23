package com.example.hxsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hxsp.bean.CartInfo;
import com.example.hxsp.bean.ProductInfo;
import com.example.hxsp.service.CartInfoService;
import com.example.hxsp.service.ProductInfoService;
import com.example.hxsp.service.exception.OutOfStockException;

@Service
public class CartInfoServiceImpl implements CartInfoService{

	@Autowired
	private ProductInfoService productInfoService;

	@Override
	public void saveCart(String uid, Integer proId) {
		// 判断商品正常 
		List<ProductInfo> existProduct = productInfoService.findPro(proId, null);
		

        if(existProduct.isEmpty()) {
        	throw new OutOfStockException("商品不存在");
        }
        // if(null != storeCart.getBargainId()) // todo 拼团砍价二期

        // 是否已经有同类型商品在购物车，有则添加数量没有则新增
        CartInfo cart = new CartInfo();
        
		
	}
}
