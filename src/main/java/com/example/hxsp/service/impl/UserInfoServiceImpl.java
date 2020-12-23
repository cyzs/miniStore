package com.example.hxsp.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.UserInfo;
import com.example.hxsp.config.WXConfig;
import com.example.hxsp.dao.UserInfoDao;
import com.example.hxsp.service.CouponService;
import com.example.hxsp.service.CouponUserService;
import com.example.hxsp.service.UserInfoService;
import com.example.hxsp.service.exception.NonExistException;
import com.example.hxsp.service.exception.WrongDataException;
import com.example.hxsp.utils.HttpClient;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private CouponUserService couponUserService;

	@Override
	public List<UserInfo> sel() {

		return userInfoDao.findAll();
	}

	/**
	 * 查询用户个人信息
	 *
	 * @param openid 小程序用户唯一标识
	 * @return
	 */
	public Map<String, Object> selUser(String openid) {
		Map<String, Object> map = new HashMap<>(3);
		try {
			// 获取用户信息
			UserInfo userInfo = new UserInfo();
			userInfo.setOpenid(openid);
			UserInfo user = userInfoDao.selUserByOpenId(userInfo);
			map.put("data", user);
			map.put("code", 0);
			map.put("msg", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "查询失败");
		}
		return map;
	}

	/**
	 * 获取小程序用户唯一标识
	 *
	 * @param code
	 * @return
	 */
	public Map<String, Object> getOpenid(String code) {
		Map<String, Object> map = new HashMap<>();
		// 调用微信那边接口，获取openID
		HttpClient httpClient = new HttpClient("");
		map.put("appid", WXConfig.APPID);
		map.put("secret", WXConfig.SECRET);
		map.put("js_code", code);
		map.put("grant_type", "authorization_code");
		String rt = "";
		try {
			rt = httpClient.getString("https://api.weixin.qq.com/sns/jscode2session", map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> rtMap = (Map<String, Object>) JSON.parse(rt);
		System.out.println("微信回调：" + rtMap);
		// 获取openID
		String openid = (String) rtMap.get("openid");
		// 根据openID判断该用户是否已存在
		UserInfo userInfo = new UserInfo();
		userInfo.setOpenid(openid);
		long num = userInfoDao.count(userInfo);
		// 不存在则添加
		if (num < 1) {
			UserInfo user = new UserInfo();
			user.setOpenid(openid);
			String naString = openid.substring(0, 5);
			user.setNickname("用户" + naString);
			user.setUserType(1);// 1-用户 2 管理员
			userInfoDao.addUser(user);
			// 将用户ID一起返回前台
			rtMap.put("userId", user.getUid());
		} else {
			UserInfo user = userInfoDao.selUserByOpenId(userInfo);
			// 将用户ID一起返回前台
			rtMap.put("userId", user.getUid());
		}

		return rtMap;
	}

	/**
	 * 登录
	 *
	 * @param user
	 * @return
	 */
	@Override
	public UserInfo login(UserInfo adminInfo) {
		// 判断账号是否存在
		UserInfo user = userInfoDao.selUserByAccount(adminInfo);
		if (user == null) {
			throw new NonExistException("账号 不存在！");
		}

		adminInfo.setPwd(DigestUtils.md5DigestAsHex(adminInfo.getPwd().getBytes()));
		List<UserInfo> list = userInfoDao.queryAll(adminInfo);

		if (list.isEmpty()) {
			throw new WrongDataException("密码错误！");
		}

		return list.get(0);
	}

	/**
	 * 添加管理员(后台)
	 * 
	 * @param account  账号
	 * @param password 密码
	 * @return
	 */
	@Override
	public Map<String, Object> add(String account, String password) {
		Map<String, Object> map = new HashMap<>(2);
		try {
			UserInfo adminInfo = new UserInfo();
			adminInfo.setAccount(account);
			UserInfo res = userInfoDao.selUserByAccount(adminInfo);
			if (res != null) {
				map.put("code", -1);
				map.put("msg", "账号已存在！");
			} else {
				// md5加密
				password = DigestUtils.md5DigestAsHex(password.getBytes());
				adminInfo.setPwd(password);
				// 影响行数(成功添加N条，num则为N)
				adminInfo.setUserType(2);
				userInfoDao.addAdmin(adminInfo);
				map.put("code", 0);
				map.put("msg", "添加成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "添加失败");
		}
		return map;
	}

	/**
	 * 删除管理员(后台)
	 * 
	 * @param adminId 管理员ID
	 * @return
	 */
//    @Override
//    public Map<String,Object> delete(Integer adminId){
//        Map<String,Object> map=new HashMap<>(2);
//        try {
//            UserInfo adminInfo = new UserInfo();
//            adminInfo.setUid(adminId);
//            //影响行数(成功删除N条，num则为N)
//            userInfoDao.delete(adminInfo);
//        }catch (Exception e){
//            e.printStackTrace();
//            map.put("code",-1);
//            map.put("msg","删除失败");
//        }
//        return map;
//    }

	/**
	 * 根据用户ID查询用户
	 *
	 * @param userId 用户ID
	 * @return
	 */
//    @Override
//    public UserInfo findUserById(Integer userId) {
//        try {
//            return userInfoDao.queryById(userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

	/**
	 * 将用户信息进行拼接
	 *
	 * @param adminInfo
	 * @return
	 */
//    @Override
//    public Map<String, Object> selUser(AdminInfo adminInfo) {
//        Map<String, Object> map = new HashMap<String, Object>(6);
//        try {
//            //用户ID
//            Integer adminId = adminInfo.getAdminId();
//            //账号
//            String account = adminInfo.getAccount();
//            //姓名
//            String name = adminInfo.getName();
//            //用户角色
//            List<Integer> roleList = new ArrayList<>();
//            roleList.add(adminInfo.getRole());
//            map.put("adminId", adminId);
//            map.put("account", account);
//            map.put("name", name);
//            map.put("roles", roleList);
//
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

	/**
	 * 修改密码（后台）
	 * 
	 * @param newPassword 新密码
	 * @param account     账号
	 * @param password    密码
	 * @return
	 */
	@Override
	public Map<String, Object> updatePwd(String account, String password, String newPassword) {
		Map<String, Object> map = new HashMap<>(2);
		try {
			// md5加密
			password = DigestUtils.md5DigestAsHex(password.getBytes());
			newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
			userInfoDao.updatePass(account, password, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "修改失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> getUser(UserInfo ui) {
		Map<String, Object> map = new HashMap<String, Object>(6);
		try {
			// 用户ID
			Integer adminId = ui.getUid();
			// 账号
			String account = ui.getAccount();
			// 姓名
			String name = ui.getNickname();
			// 用户角色
			String userType = ui.getUserType() == 2 ? "管理员" : "用户";
			map.put("adminId", adminId);
			map.put("account", account);
			map.put("name", name);
			map.put("roles", userType);

			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> select(int pageNo, int pageSize, String nickname) {
		Map<String, Object> map = new HashMap<>(4);
		try {
			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
			}
			// 管理员列表
			List<UserInfo> list = userInfoDao.select(pageNo, pageSize, nickname);
			// 管理员总数
			UserInfo userInfo = new UserInfo();
			userInfo.setNickname(nickname);
			long count = userInfoDao.count(userInfo);
			map.put("total", count);
			map.put("data", list);
			map.put("code", 0);
			map.put("msg", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "查询失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> getCouponAndIintegralNum(String uid, Integer status ) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		Long csize = couponUserService.findMyAvailableCouponNum(uid, status);
		Integer inte = userInfoDao.queryById(Integer.parseInt(uid)).getIntegral();
		map.put("csize", csize);
		map.put("inte", inte);
		return map;
	}

	@Override
	public UserInfo selUserInfoByUid(Integer uid) {
		return userInfoDao.selUserInfoByUid(uid);
	}

	@Override
	public void modifyIntegral(Integer uid, Integer gainIntegral) {
		userInfoDao.modifyIntegral(uid,gainIntegral);
	}
}
