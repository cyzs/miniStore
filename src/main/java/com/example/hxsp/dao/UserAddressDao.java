package com.example.hxsp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.UserAddress;

@Repository
public interface UserAddressDao {

	/**
	 * 新增
	 * @param uid
	 * @param realName
	 * @param phone
	 * @param province
	 * @param city
	 * @param district
	 * @param cityId
	 * @param detail
	 * @param postCode
	 * @param longitude
	 * @param latitude
	 * @param isDefault
	 */
	void insertOne(UserAddress userAdress);

	/**
	 * 更新
	 * @param id
	 * @param realName
	 * @param phone
	 * @param province
	 * @param city
	 * @param district
	 * @param cityId
	 * @param detail
	 * @param postCode
	 * @param longitude
	 * @param latitude
	 * @param isDefault
	 */
	void updateOne(Integer id, String realName, String phone, String province, String city, String district,
			Integer cityId, String detail, String postCode, String longitude, String latitude, Integer isDefault, String address);

	/**
	 * 将我的收货地址列表全部改为非默认
	 * @param uid
	 */
	void updateAllToNonDefault(Integer uid);

	/**
	 * 删除
	 * @param id
	 */
	void delOne(Integer id);

	/**
	 * 查询我的收货地址列表
	 * @param uid
	 * @return
	 */
	List<UserAddress> findAllByUid(Integer uid, Integer id);

}
