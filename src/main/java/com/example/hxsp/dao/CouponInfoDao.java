package com.example.hxsp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.CouponInfo;

@Repository
public interface CouponInfoDao {

	/**
	 * 查询所有
	 * @return
	 */
	List<CouponInfo> findAllCoupon(Integer status);

	/**
	 * 新增
	 * @param name
	 * @param money
	 * @param isLimited
	 * @param total
	 * @param useType
	 * @param primaryKey
	 * @param minPrice
	 * @param receiveStartTime
	 * @param receiveEndTime
	 * @param useStartTime
	 * @param useEndTime
	 * @param type
	 */
	Integer insertOne(CouponInfo couponInfo);
	/**
	 * 更新
	 * @param id
	 * @param name
	 * @param money
	 * @param isLimited
	 * @param total
	 * @param useType
	 * @param primaryKey
	 * @param minPrice
	 * @param receiveStartTime
	 * @param receiveEndTime
	 * @param useStartTime
	 * @param useEndTime
	 * @param type
	 * @param status
	 */
	void updateOne(Integer id, String name, Double money, Integer isLimited, Integer total, Integer useType,
			Integer primaryKey, Double minPrice, Date receiveStartTime, Date receiveEndTime, Date useStartTime, Date useEndTime, Integer type, Integer status);

	/**
	 * 查询一条
	 * @param id
	 * @return
	 */
	List<CouponInfo> findOne(Integer id);

	/**
	 * 削減庫存
	 * @param id
	 */
	void minus(Integer id);

	void updateLastTotal(Integer id, Integer lastTotal);

	void del(int parseInt);
	
	/**
	 * 查询 可领取时间过期的数据
	 * @param couponInfo
	 * @return
	 */
	List<CouponInfo> findReceivedEndTimeExpired(CouponInfo couponInfo);

	/**
	 * 查询 可使用时间过期的数据
	 * @param couponInfo
	 * @return
	 */
	List<CouponInfo> findUseEndTimeExpired(CouponInfo couponInfo);

	/**
	 * 查询 可使用时间开始的过期数据
	 * @param couponInfo
	 * @return
	 */
	List<CouponInfo> findUseStartTimeExpired(CouponInfo couponInfo);
	
	/**
	 * 更改状态
	 * @param status
	 */
	void updateStatus(Integer status, Integer id);

}
