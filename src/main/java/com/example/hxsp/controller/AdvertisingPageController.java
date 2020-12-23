package com.example.hxsp.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hxsp.bean.AdvertisingPage;
import com.example.hxsp.service.AdvertisingPageService;
import com.example.hxsp.service.CouponService;
import com.example.hxsp.service.ProductInfoService;
import com.example.hxsp.utils.JsonResult;

/**
 * 首页广告轮播图
 */
@Slf4j
@RestController
@RequestMapping("hxsp/ads")
public class AdvertisingPageController extends BaseController {

	@Autowired
	private AdvertisingPageService advertisingPageService;

	@Autowired
	private ProductInfoService productInfoService;

	@Autowired
	private CouponService couponService;

	/**
	 * 管理员查看所有广告轮播信息
	 * 
	 * @return
	 */
	@RequestMapping("all")
	public JsonResult<List<AdvertisingPage>> selAds() {
		return new JsonResult<List<AdvertisingPage>>(SUCCESS, advertisingPageService.getAds());
	}

	/**
	 * 查询上架的
	 * 
	 * @param productId 产品id
	 * @param type      类型：1.商品，2.优惠券3.文章等
	 * @return
	 */
	@RequestMapping("show")
	public JsonResult<List> selAdsShow(Integer productId, Integer type) {
		if (null!=type&&type == 1) {
			// 商品
			return new JsonResult<List>(SUCCESS, productInfoService.findPro(productId, null));
		} else if (null!=type&&type == 2) {
			// 优惠券
			return new JsonResult<List>(SUCCESS, couponService.sel(productId));
		}
		// 无传参，则查询所有上架的轮播商品
		return new JsonResult<List>(SUCCESS, advertisingPageService.getAdsShow());
	}

	/**
	 * 上下架
	 * 
	 * @param id
	 * @param type 0-下架
	 * @return
	 */
	@RequestMapping("onOffSale")
	public JsonResult<Void> putOnSale(Integer id, Integer type) {
		advertisingPageService.setOnOffSale(id, type);
		return new JsonResult<>(SUCCESS);
	}

	/**
	 * 添加
	 * 
	 * @param productId 产品id
	 * @param type      类型：1.商品，2.优惠券3.文章等
	 * @param path      路径链接
	 * @param image     图片
	 * @param sort      排序
	 * @param isShow    状态（0：未上架，1：上架）
	 * @return
	 */
	@RequestMapping("add")
	public JsonResult<Void> addOneAd(Integer productId, Integer type, String path, String image, Integer sort,
			Integer isShow) {
		advertisingPageService.create(productId, type, path, image, sort, isShow);
		return new JsonResult<>(SUCCESS);
	}
	
	/**
	 * 添加
	 * 
	 * @param productId 产品id
	 * @param type      类型：1.商品，2.优惠券3.文章等
	 * @param path      路径链接
	 * @param image     图片
	 * @param sort      排序
	 * @param isShow    状态（0：未上架，1：上架）
	 * @return
	 */
	@RequestMapping("change")
	public JsonResult<Void> changeOneAd(Integer id, Integer productId, Integer type, String path, String image, Integer sort,
			Integer isShow) {
		advertisingPageService.change(id,productId, type, path, image, sort, isShow);
		return new JsonResult<>(SUCCESS);
	}
	@RequestMapping("del")
	public JsonResult<Void> delOneAd(String ids) {
		advertisingPageService.del(ids);
		return new JsonResult<>(SUCCESS);
	}

}
