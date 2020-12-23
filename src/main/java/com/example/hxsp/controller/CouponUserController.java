package com.example.hxsp.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hxsp.bean.CouponUser;
import com.example.hxsp.service.CouponUserService;
import com.example.hxsp.utils.JsonResult;


/**
 * 优惠券发放记录表 
 * 
 * 领券操作
 */
@Slf4j
@RestController
@RequestMapping("hxsp/coupon/user")
public class CouponUserController extends BaseController{

	@Autowired
	private CouponUserService couponUserService;
   
	/**
	 * 我的优惠券
	 * @param uid 用户id
	 * @param status 状态（0：未使用，1：已使用, 2:已失效）
	 * @return
	 */
	@RequestMapping("/list")
	public JsonResult<List<CouponUser>> myList(Integer uid, Integer status){
		return new JsonResult<List<CouponUser>>(SUCCESS,couponUserService.selMyList(uid, status));
	}
	
	/**
	 * 领券
	 * @param uid 用户id
	 * @param id 券id
	 * @return
	 */
	@RequestMapping("/rev")
	private JsonResult<Map<String,Object>> receive(Integer uid, Integer id){
		//判断用户是否已领取
		long num=couponUserService.alreadyReceived(uid,id);
		Map<String,Object> map=new HashMap<>();
		if (num>0){
			map.put("msg","不可重复领取");
			map.put("code",-1);
		}else {
			couponUserService.receiveOne(uid, id);
			map.put("msg","领取成功");
			map.put("code",0);
		}
		return new JsonResult<Map<String,Object>>(SUCCESS,map);


	}
	
}



