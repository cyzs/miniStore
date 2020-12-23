package com.example.hxsp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.UserInfo;

/**
 * 用户表
 * @author Administrator
 *
 */
@Repository
public interface UserInfoDao {

	/**
	 * 查询所有
	 * @return
	 */
	List<UserInfo> findAll();

	
	long count(UserInfo userInfo);


	void addAdmin(UserInfo user);
	void addUser(UserInfo user);



	UserInfo selUserByOpenId(UserInfo userInfo);


	long isUserIn(UserInfo adminInfo);


	List<UserInfo> queryAll(UserInfo adminInfo);


	void delete(UserInfo adminInfo);


	UserInfo queryById(Integer uid);


	void updatePass(String account, String pwd, String npwd);

/**
 * 查询用户信息
 * @param pageNo
 * @param pageSize
 * @param name
 * @return
 */
	List<UserInfo> select(int pageNo, int pageSize, String name);


	UserInfo selUserByAccount(UserInfo adminInfo);

	/**
	 * 修改积分
	 * @param uid 用户id
	 * @param gainIntegral 获得积分
	 */
	void modifyIntegral(Integer uid,Integer gainIntegral);


//	long count2(int pageNo, int pageSize, String name);

	/**
	 * 根据uid查询用户信息
	 * @param uid
	 * @return
	 */
	UserInfo selUserInfoByUid(Integer uid);

}
