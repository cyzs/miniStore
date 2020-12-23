package com.example.hxsp.controller;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.CouponUser;
import com.example.hxsp.service.CouponService;
import com.example.hxsp.utils.JsonResult;


/**
 * 优惠券表
 * 
 */
@Slf4j
@RestController
@RequestMapping("hxsp/coupon")
public class CouponController extends BaseController {

	@Autowired
	private CouponService couponService;
	
	/**
	 * 分页查看发放的所有优惠券
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list")
	public JsonResult<Map<String, Object>> allCoupon(Integer pageNo, Integer pageSize){
		return new JsonResult<Map<String, Object>>(SUCCESS, couponService.getAllCoupon(pageNo, pageSize));
	}
	
	
	/**
	 * 可领取的优惠券
	 * @return
	 */
	@RequestMapping("/ava")
	public JsonResult<List<Document>> myList(Integer uid){
		return new JsonResult<List<Document>>(SUCCESS,couponService.selAvaliableList(uid));
	}
	
	/**
	 * 查询优惠券
	 * @return
	 */
	@RequestMapping("/sel")
	public JsonResult<List<CouponInfo>> sel(Integer id){
		return new JsonResult<List<CouponInfo>>(SUCCESS,couponService.sel(id));
	}
	
	
	/**
	 * 添加一个优惠券
	 * @param name 名称
	 * @param money 金额
	 * @param isLimited 数量是否有限
	 * @param total 总数量
	 * @param useType  使用类型 1 全场通用, 2 商品券, 3 品类券 
	 * @param primaryKey 所属商品id / 分类id
	 * @param minPrice 最低消费
	 * @param receiveStartTime 可领取开始时间
	 * @param receiveEndTime 可领取结束时间
	 * @param useStartTime 可使用时间范围 开始时间
	 * @param useEndTime 可使用时间范围 结束时间
	 * @param type 优惠券类型 1 手动领取, 2 新人券, 3 赠送券
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("add")
	public JsonResult<Void> addOne(String name, Double money, Integer isLimited, Integer total, Integer useType, 
			Integer primaryKey, Double minPrice, String receiveStartTime, String receiveEndTime, String useStartTime, String useEndTime, Integer type) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date rst = null;
		Date ret = null;
		Date ust = null;
		Date uet = null;
		
		if(!receiveStartTime.isEmpty()) {
			rst = sdf.parse(receiveStartTime);
		}
		if(!receiveEndTime.isEmpty()) {
			ret = sdf.parse(receiveEndTime);
		}
		if(!useStartTime.isEmpty()) {
			ust = sdf.parse(useStartTime);
		}
		if(!useEndTime.isEmpty()) {
			uet = sdf.parse(useEndTime);
		}
		couponService.addOneCoupon(name, money, isLimited, total, useType, primaryKey, minPrice, rst, ret, ust,
				uet, type);
		return new JsonResult<Void>(SUCCESS);
	}
	
	/**
	 * 修改一个优惠券
	 * @param name 名称
	 * @param money 金额
	 * @param isLimited 数量是否有限
	 * @param total 总数量
	 * @param useType  使用类型 1 全场通用, 2 商品券, 3 品类券 
	 * @param primaryKey 所属商品id / 分类id
	 * @param minPrice 最低消费
	 * @param useStartTime 可使用时间范围 开始时间
	 * @param useEndTime 可使用时间范围 结束时间
	 * @param type 优惠券类型 1 手动领取, 2 新人券, 3 赠送券
	 * @param status 状态（0：关闭，1：开启）
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("change")
	public JsonResult<Void> changeOne(Integer id, String name, Double money, Integer isLimited, Integer total, Integer useType, 
			Integer primaryKey, Double minPrice, String receiveStartTime, String receiveEndTime, String useStartTime, String useEndTime, Integer type, Integer status) throws ParseException{
		couponService.changeOneCoupon(id, name, money, isLimited, total, useType, primaryKey, minPrice, receiveStartTime, receiveEndTime, useStartTime,
				useEndTime, type, status);
		return new JsonResult<Void>(SUCCESS);
	}
	
	@RequestMapping("del")
	public JsonResult<Void> del(String ids) {
		couponService.del(ids);
		return new JsonResult<Void>(SUCCESS);
	}
	
	
	
}



