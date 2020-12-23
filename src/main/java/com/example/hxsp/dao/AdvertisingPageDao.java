package com.example.hxsp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.AdvertisingPage;

/**
 *  首页广告轮播图
 * @author Administrator
 *
 */
@Repository
public interface AdvertisingPageDao {

	/**
	 * 查询所有
	 * @return
	 */
	public List<AdvertisingPage> findAllAds();

	/**
	 * 查询所有上架
	 * @return
	 */
	public List<AdvertisingPage> findAllAdsShow();

	/**
	 * 下架
	 * @param id
	 * @return
	 */
	public void setOffSale(Integer id);

	/**
	 * 上架
	 * @param id
	 */
	public void setOnSale(Integer id);

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
	public void save(AdvertisingPage advertisingPage);

	public void del(int parseInt);

	public void change(AdvertisingPage advertisingPage);
}
