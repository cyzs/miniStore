package com.example.hxsp.service;

public interface CartInfoService {

	/**
	 * 新增购物车表
	 * @param uid 用户id
	 * @param proId 商品id
	 * @return
	 */
	void saveCart(String uid, Integer proId);

}
