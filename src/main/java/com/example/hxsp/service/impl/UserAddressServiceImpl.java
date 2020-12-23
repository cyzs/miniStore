package com.example.hxsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hxsp.bean.UserAddress;
import com.example.hxsp.dao.UserAddressDao;
import com.example.hxsp.service.UserAddressService;

@Service
public class UserAddressServiceImpl implements UserAddressService{
	
	@Autowired
	private UserAddressDao userAddressDao;

	@Override
	public void addOneAddress(Integer uid, String realName, String phone, String province, String city, String district,
			Integer cityId, String detail, String postCode, String longitude, String latitude,Integer isDefault, String address) {
		
		UserAddress userAdress = new UserAddress();
		userAdress.setUid(uid);
		userAdress.setRealName(realName);
		userAdress.setPhone(phone);
		userAdress.setProvince(province);
		userAdress.setCity(city);
		userAdress.setDistrict(district);
		userAdress.setCityId(cityId);
		userAdress.setDetail(detail);
		userAdress.setPostCode(postCode);
		userAdress.setLongitude(longitude);
		userAdress.setLatitude(latitude);
		userAdress.setIsDefault(isDefault);
		userAdress.setAddress(address);
		userAddressDao.insertOne(userAdress);
		
	}

	@Override
	public void changeOneAddress(Integer id, Integer uid, String realName, String phone, String province, String city,
			String district, Integer cityId, String detail, String postCode, String longitude, String latitude,
			Integer isDefault, String address) {
		
		if(isDefault==1) {
			//将之前的默认地址设置为非默认地址
			changeAllToNonDefaule(uid);
		}
		userAddressDao.updateOne(id, realName, phone, province, city, district, cityId, 
				detail, postCode, longitude, latitude, isDefault, address);
		
	}
	
	public void changeAllToNonDefaule(Integer uid) {
		userAddressDao.updateAllToNonDefault(uid);
	}

	@Override
	public void removeOneAddress(List<Integer> idsList) {
		for (Integer id : idsList) {
			userAddressDao.delOne(id);
		}
		
	}

	@Override
	public List<UserAddress> selAll(Integer uid, Integer id) {
		return userAddressDao.findAllByUid(uid, id);
	}

}
