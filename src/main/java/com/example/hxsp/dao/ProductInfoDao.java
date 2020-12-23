package com.example.hxsp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.ProductInfo;

/**
 * 商品表
 * @author Administrator
 *
 */
@Repository
public interface ProductInfoDao {

	/**
	 * 查询所有商品
	 * @return
	 */
	List<ProductInfo> selAll();
	
	/**
	 * 查询所有商品
	 * @return
	 */
	List<ProductInfo> selAlla(ProductInfo productInfo);


	/**
	 * 查询所有上架的热门类商品
	 * @return
	 */
	List<ProductInfo> selAllHotProductsOnSale();

	/**
	 * 查询所有积分类商品
	 * @return
	 */
	List<ProductInfo> selAllIntegralProducts();

	
	/**
	 * 查询所有积分类商品
	 * @return
	 */
	List<ProductInfo> selAllIntegralProduct(ProductInfo productInfo);

	/**
	 * 查询所有上架的积分类商品
	 * @return
	 */
	List<ProductInfo> selAllIntProductsOnSale();

	/**
	 * 查询指定id的商品
	 * @param id
	 * @return
	 */
	List<ProductInfo> selProById(Integer id);

	/**
	 * 上架
	 * @param id
	 */
	void setProOnSale(Integer id);

	/**
	 * 下架
	 * @param id
	 */
	void setProOffSale(Integer id);

	/**
	 * 新增
	 */
	void insertOne(ProductInfo productInfo);

	/**
	 * 更新
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
	void updateOne(Integer id, String images, String name, String info, String keyword, Integer cateId,
			Double price, Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot,
			Integer isPostage, Integer giveIntegral, Double cost, String videoLink, Integer tempId);

	/**
	 * 查询该分类id的商品
	 * @param cateId
	 * @return
	 */
	List<ProductInfo> selProByCateId(Integer cateId);

	void delete(int id);

	/**
	 * 查询所有已上架商品
	 * @return
	 */
	List<ProductInfo> selAllProduct();

}
