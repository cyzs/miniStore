package com.example.hxsp.service;

import java.util.List;

import com.example.hxsp.bean.AdvertisingPage;

/**
 * 首页广告轮播图
 * @author Administrator
 *
 */
public interface AdvertisingPageService {

	/**
	 * 管理员查看所有广告轮播信息
	 * 
	 * @return
	 */
	List<AdvertisingPage> getAds();

	/**
	 * 查询上架的
	 * @return
	 */
	List<AdvertisingPage> getAdsShow();

	/**
	 * 上下架
	 * @param id 
	 * @param type 0-下架
	 * @return 
	 */
	void setOnOffSale(Integer id, Integer type);

	/**
	 * 添加
	 * @param productId 产品id
	 * @param type 类型：1.商品，2.优惠券3.文章等
	 * @param path 路径链接
	 * @param image 图片
	 * @param sort 排序
	 * @param isShow  状态（0：未上架，1：上架）
	 * @return
	 */
	void create(Integer productId, Integer type, String path, String image, Integer sort, Integer isShow);


	/**
	 * 添加
	 * @param productId 产品id
	 * @param type 类型：1.商品，2.优惠券3.文章等
	 * @param path 路径链接
	 * @param image 图片
	 * @param sort 排序
	 * @param isShow  状态（0：未上架，1：上架）
	 * @return
	 */
	void change(Integer id, Integer productId, Integer type, String path, String image, Integer sort, Integer isShow);

	void del(String ids);



}
