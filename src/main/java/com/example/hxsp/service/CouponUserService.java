package com.example.hxsp.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.hxsp.bean.CouponUser;
import com.example.hxsp.bean.OrderInfo;

public interface CouponUserService {

	/**
	 * 用户已领取的券
	 * @param uid 用户id
	 * @param status 状态（0：未使用，1：已使用, 2:已失效）
	 * @return
	 */
	List<CouponUser> selMyList(Integer uid, Integer status);

	/**
	 * 领券
	 * @param uid
	 * @param id
	 */
	void receiveOne(Integer uid, Integer id);

	/**
	 * 使用券
	 * @param id
	 * @param productIdList
	 * @param price
	 * @return
	 */
	boolean use(Integer id, List<Integer> productIdList, BigDecimal price);

	/**
	 * 检测优惠券是否可用，计算订单价格时使用
	 * @param id            优惠券id
	 * @param productIdList 商品id集合
	 * @param price 价格
	 * @return  可用状态
	 */
	boolean canUse(Integer id, List<Integer> productIdList, BigDecimal price);

	/**
	 * 取消訂單后退回优惠券
	 * @param order
	 * @return
	 */
	boolean rollbackByCancelOrder(OrderInfo order);
	
	Long findMyAvailableCouponNum(String uid, Integer status);

	/**
	 * 判断用户是否已领取该优惠券
	 * @param uid
	 * @param id
	 * @return
	 */
	long alreadyReceived(Integer uid, Integer id);

}
