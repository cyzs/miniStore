package com.example.hxsp.service;

import java.util.List;
import java.util.Map;

import com.example.hxsp.bean.ProductInfo;

public interface ProductInfoService {

	/**
	 * 分页查询商品
	 * @param pageNo
	 * @param pageSize
	 * @param type 0-非积分 1-积分类
	 * @return
	 */
	Map<String, Object> findAll(Integer pageNo, Integer pageSize, Integer type, Integer cateId, String productName, Integer isShow);

	/**
	 * 查询所有上架的热门商品
	 * @return
	 */
	List<ProductInfo> findAllHotProductsOnSale();

	/**
	 * 查询所有积分类商品
	 * @return
	 */
	List<ProductInfo> findAllIntegralProducts();

	/**
	 * 查询所有上架的积分类商品
	 * @return
	 */
	List<ProductInfo> findAllIntProductsOnSale();

	/**
	 * 查询商品（指定商品id，或分类id）
	 * @param id
	 * @param cateId
	 * @return
	 */
	List<ProductInfo> findPro(Integer id, Integer cateId);

	/**
	 * 上下架指定的商品
	 * @param id
	 * @param type 0-下架， 1-上架
	 * @return
	 */
	void setOnOffSale(Integer id, Integer type);


	/**
	 * 新增
	 * @param images
	 * @param name
	 * @param info
	 * @param keyword
	 * @param cateId
	 * @param price
	 * @param otPrice
	 * @param type
	 * @param unit
	 * @param stock
	 * @param isShow
	 * @param isHot
	 * @param isPostage
	 * @param giveIntegral
	 * @param cost
	 * @param videoLink
	 * @param tempId
	 */
	void addNewPro(String images, String name, String info, String keyword, Integer cateId, Double price,
			Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot, Integer isPostage,
			Integer giveIntegral, Double cost, String videoLink, Integer tempId);

	/**
	 * 更改
	 * @param id
	 * @param images
	 * @param name
	 * @param info
	 * @param keyword
	 * @param cateId
	 * @param price
	 * @param otPrice
	 * @param type
	 * @param unit
	 * @param stock
	 * @param isShow
	 * @param isHot
	 * @param isPostage
	 * @param giveIntegral
	 * @param cost
	 * @param videoLink
	 * @param tempId
	 */
	void changePro(Integer id, String images, String name, String info, String keyword, Integer cateId,
			Double price, Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot,
			Integer isPostage, Integer giveIntegral, Double cost, String videoLink, Integer tempId);

	void delPro(String ids);

	/**
	 * 查询所有已上架商品
	 * @return
	 */
	List<ProductInfo> selAllProduct();

}
