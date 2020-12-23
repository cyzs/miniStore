package com.example.hxsp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.CouponUser;
import com.example.hxsp.utils.JsonResult;

@Repository
public interface CouponUserDao {

	/**
	 * 查询我的优惠券
	 * @param uid
	 * @param status
	 * @return
	 */
	List<CouponUser> findMyList(Integer uid, Integer status);
	/**
	 * 查询我的优惠券
	 * @param uid
	 * @param status
	 * @return
	 */
	Long findMyListNum(String uid, Integer status);

	/**
	 * 查询指定优惠券
	 * @param uid
	 * @param id
	 * @return
	 */
	List<CouponUser> findByUidAndId(Integer uid, Integer id);
	
	/**
	 * 新增
	 * @param CouponUser
	 */
	void save(CouponUser CouponUser);
	
	/**
	 * 更改状态： 使用时间过期的 且尚未使用的
	 * @param status
	 * @param couponId
	 * @param ostatus
	 */
	void updateStatus(Integer status, Integer couponId, Integer ostatus);

	/**
	 * 判断用户是否已领取该优惠券
	 * @param uid
	 * @param id
	 * @return
	 */
	long alreadyReceived(Integer uid, Integer id);
}
