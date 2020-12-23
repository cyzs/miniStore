package com.example.hxsp.controller;

import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.hxsp.bean.UserInfo;
import com.example.hxsp.service.UserInfoService;
import com.example.hxsp.utils.JsonResult;
import com.example.hxsp.utils.PassToken;

/**
 * 用户管理 操作用户表：增删改查、积分
 * @author summer
 *
 */
@RestController
@RequestMapping("hxsp/user")
public class UserInfoController extends BaseController {

	@Autowired
	private UserInfoService userService;

	/**
	 * 查询用户表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonResult<List<UserInfo>> getList() {
		return new JsonResult<List<UserInfo>>(SUCCESS, userService.sel());
	}
	/**
	 * 查询用户个人信息(小程序)
	 * @param openid 小程序用户唯一标识
	 * @return
	 */
	//    @PassToken
	@RequestMapping("selUser")
	@ResponseBody
	public String selUser(String openid) {
		return JSON.toJSONStringWithDateFormat(userService.selUser(openid),"yyyy-MM-dd", SerializerFeature.WriteMapNullValue);
	}


	/**
	 * 修改个人资料(小程序)
	 * @param userName 姓名
	 * @param birthday 生日
	 * @param userId 用户ID
	 * @return
	 */
	//    @PassToken
	//    @RequestMapping("update")
	//    @ResponseBody
	//    public String update(Integer userId,String userName,String birthday){
	//        return JSON.toJSONString(userService.update(userId,userName,birthday));
	//    }

	/**
	 * 获取小程序唯一标识(小程序)
	 * @param code
	 * @return
	 */
	@PassToken
	@RequestMapping("getOpenid")
	@ResponseBody
	public String getOpenid(@RequestParam("code") String code){
		return JSON.toJSONString(userService.getOpenid(code));
	}


	/**
	 * 查询用户列表(后台)
	 * @param pageNo 页数
	 * @param pageSize 页码
	 * @param userName 姓名
	 * @return
	 */
	@RequestMapping("select")
	@ResponseBody
	public String select(int pageNo,int pageSize,String userName){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+16"));
		return JSON.toJSONStringWithDateFormat(userService.select(pageNo, pageSize,userName),"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
	}

	/**
	 * 修改密码（后台）
	 * @param newPassword 新密码
	 * @param account 账号
	 * @param password 密码
	 * @return
	 */

	@RequestMapping("pwd")
	@ResponseBody
	public String updatePass(String account,String password,String newPassword){
		return JSON.toJSONString(userService.updatePwd(account,password,newPassword));
	}

	/**
	 * 添加管理员(后台)
	 * @param account 账号
	 * @param password 密码
	 * @return
	 */
	//    @RequestMapping("addadm")
	//    @ResponseBody
	public String add(String account,String pwd){
		return JSON.toJSONString(userService.add(account,pwd));
	}
	
	/**
	 * 獲取我的优惠券数量以及积分总数
	 */
	@RequestMapping(value = "/ci", method = RequestMethod.GET)
	public JsonResult<Map<String, Object>> getCouponAndIintegralNum(String uid, Integer status ) {
		return new JsonResult<Map<String, Object>>(SUCCESS, userService.getCouponAndIintegralNum(uid, status));
	}

}
