package com.example.hxsp.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hxsp.bean.UserAddress;
import com.example.hxsp.service.UserAddressService;
import com.example.hxsp.utils.JsonResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户收货地址表
 * 
 *
 */
@Slf4j
@RestController
@RequestMapping("hxsp/order/address")
public class UserAddressController extends BaseController{

	@Autowired
	private UserAddressService userAddressService;
	
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
	@RequestMapping("/save")
	public JsonResult<Void> addOne(Integer uid, String realName, String phone, String province, String city, 
			String district, Integer cityId, String detail, String postCode, String longitude,
			String latitude, Integer isDefault, String address) {
		userAddressService.addOneAddress(uid, realName, phone, province, city, district, cityId, 
				detail, postCode, longitude, latitude, isDefault, address);
		return new JsonResult<Void>(SUCCESS);
	}
	
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
	@RequestMapping("/up")
	public JsonResult<Void> changeOne(Integer id, Integer uid, String realName, String phone, String province, String city, 
			String district, Integer cityId, String detail, String postCode, String longitude,
			String latitude, Integer isDefault, String address) {
		userAddressService.changeOneAddress(id, uid, realName, phone, province, city, district, cityId, 
				detail, postCode, longitude, latitude, isDefault, address);
		return new JsonResult<Void>(SUCCESS);
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/del")
	public JsonResult<Void> removeOne(String ids) {
		List<Integer> idsList= (List<Integer>) JSON.parse(ids);
		userAddressService.removeOneAddress(idsList);
		return new JsonResult<Void>(SUCCESS);
	}
	
	/**
	 * 查询 
	 * @param uid
	 * @return
	 */
	@RequestMapping("/list")
	public JsonResult<List<UserAddress>> getAll(Integer uid, Integer id) {
		return new JsonResult<List<UserAddress>>(SUCCESS, userAddressService.selAll(uid, id));
	}
	
}
