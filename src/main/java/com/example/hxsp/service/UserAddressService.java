package com.example.hxsp.service;

import java.util.List;

import com.example.hxsp.bean.UserAddress;

public interface UserAddressService {

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
	 */
	void addOneAddress(Integer uid, String realName, String phone, String province, String city, String district,
			Integer cityId, String detail, String postCode, String longitude, String latitude,Integer isDefault, String address);

	/**
	 * 修改
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
	 */
	void changeOneAddress(Integer id, Integer uid, String realName, String phone, String province, String city, String district,
			Integer cityId, String detail, String postCode, String longitude, String latitude, Integer isDefault, String address);

	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	void removeOneAddress(List<Integer> idsList);

	/**
	 * 查询 
	 * @param uid
	 * @return
	 */
	List<UserAddress> selAll(Integer uid, Integer id);

}
