package com.example.hxsp.service;

import java.util.List;
import java.util.Map;

import com.example.hxsp.bean.UserInfo;

public interface UserInfoService {

	/**
	 * 查询用户表
	 */
	List<UserInfo> sel();

//	Object delUser(Integer userId);
//
//	Object select(int pageNo, int pageSize, String userName);

	Object getOpenid(String code);

	Object selUser(String openid);

	UserInfo login(UserInfo adminInfo);

	Map<String, Object> getUser(UserInfo userInfo);

	Object select(int pageNo, int pageSize, String userName);

	Object updatePwd(String account, String password, String newPassword);

	Object add(String account, String password);

	Map<String, Object> getCouponAndIintegralNum(String uid, Integer status);

//	Object update(Integer userId, String userName, String birthday);
	/**
	 * 根据uid查询用户信息
	 * @param uid
	 * @return
	 */
	UserInfo selUserInfoByUid(Integer uid);
	/**
	 * 修改积分
	 * @param uid 用户id
	 * @param gainIntegral 获得积分
	 */
	void modifyIntegral(Integer uid,Integer gainIntegral);

}
