package com.example.hxsp.controller;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hxsp.bean.ProductInfo;
import com.example.hxsp.service.ProductInfoService;
import com.example.hxsp.utils.JsonResult;



/**
 * 商品表:  商品增刪改查操作、商品上下架
 * 
 * 
 */
@Slf4j
@RestController
@RequestMapping("hxsp/product")
public class ProductController extends BaseController{
    
	@Autowired
	private ProductInfoService productInfoService;
	
	
	/**
	 * 查询
	 * @param id 商品id
	 * @param isIntegral 是否积分类商品 0-否 1-是
	 * @param isHot 是否热门类商品 0-否 1-是
	 * @param cateId 分类id
	 * @return
	 */
	@RequestMapping("info")
	public JsonResult<List<ProductInfo>> getProById(Integer id, Integer isIntegral, Integer isHot, Integer cateId,Integer isAll){
		//查看指定商品id 查看分类或全部商品
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ProductInfo> findPro = null;
		if (isAll==null){
			isAll=0;
		}
		if (isAll==1){
			//查询全部商品
			findPro=productInfoService.selAllProduct();
		}else if(id!=null||cateId!=null) {
			findPro = productInfoService.findPro(id, cateId);
		}
		//查看积分类商品
		else if(null!=isIntegral&&isIntegral==1) {
			findPro = productInfoService.findAllIntProductsOnSale();
		}
		//查看热门类商品
		else if(null!=isHot&&isHot==1) {
			findPro = productInfoService.findAllHotProductsOnSale();
		}
		if (findPro==null){
			return new JsonResult<List<ProductInfo>>(SUCCESS,findPro);
		}
		for (ProductInfo productInfo : findPro) {
			try {
				productInfo.setUpdateTime(sdf.parse(sdf.format(productInfo.getUpdateTime())));
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
		}
		return new JsonResult<List<ProductInfo>>(SUCCESS,findPro);
	}
	
	/**
	 *  分页查看所有商品信息
	 * @param pageNo
	 * @param pageSize
	 * @param type 0-非积分 1-积分
	 * @return
	 */
	@RequestMapping("all")
	public JsonResult<Map<String, Object>> getAll(Integer pageNo, Integer pageSize, Integer type, Integer cateId, String productName, Integer isShow){
			return new JsonResult<Map<String, Object>>(SUCCESS,productInfoService.findAll(pageNo, pageSize, type, cateId, productName, isShow));
	}
	
	
	/**
	 * 上下架指定的商品
	 * @param id
	 * @param type 0-下架， 1-上架
	 * @return
	 */
	@RequestMapping("setOnOffSale")
	public JsonResult<Void> setOnSale(Integer id, Integer type){
		productInfoService.setOnOffSale(id, type);
		return new JsonResult<>(SUCCESS);
	}
	
	
	/**
	 * 添加商品
	 * @param images 图片、轮播图
	 * @param name 商品名
	 * @param info 简介
	 * @param keyword 关键词
	 * @param cateId 分类id
	 * @param price 价格、积分价
	 * @param otPrice 市场价
	 * @param type 类型 0-普通商品 1-积分商品
	 * @param unit 计量单位
	 * @param stock 库存
	 * @param isShow 是否上架 0-否 1-是
	 * @param isHot 是否热门 0-否 1-是
	 * @param isPostage 是否包邮 0-否 1-是
	 * @param giveIntegral 购买此商品获得的积分
	 * @param cost 成本价
	 * @param videoLink 视频链接
	 * @param tempId 运费模板
	 * @return
	 */
	@RequestMapping("add")
	public JsonResult<Void> addPro(String images, String name, String info, String keyword, Integer cateId, Double price, 
			Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot, Integer isPostage, 
			Integer giveIntegral, Double cost, String videoLink, Integer tempId ){
		productInfoService.addNewPro(images, name, info, keyword, cateId, price,  otPrice, type, unit, stock, isShow, isHot,
				isPostage, giveIntegral, cost, videoLink, tempId);
		return new JsonResult<Void>(SUCCESS);
	}
	
	/**
	 * 修改商品
	 * @param id 商品id
	 * @param images 图片、轮播图
	 * @param name 商品名
	 * @param info 简介
	 * @param keyword 关键词
	 * @param cateId 分类id
	 * @param price 价格、积分价
	 * @param otPrice 市场价
	 * @param type 类型 0-普通商品 1-积分商品
	 * @param unit 计量单位
	 * @param stock 库存
	 * @param isShow 是否上架 0-否 1-是
	 * @param isHot 是否热门 0-否 1-是
	 * @param isPostage 是否包邮 0-否 1-是
	 * @param giveIntegral 购买此商品获得的积分
	 * @param cost 成本价
	 * @param videoLink 视频链接
	 * @param tempId 运费模板
	 * @return
	 */
	@RequestMapping("change")
	public JsonResult<Void> addPro(Integer id, String images, String name, String info, String keyword, Integer cateId, Double price, 
			Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot, Integer isPostage, 
			Integer giveIntegral, Double cost, String videoLink, Integer tempId ){
		productInfoService.changePro(id, images, name, info, keyword, cateId, price,  otPrice, type, unit, stock, isShow, isHot,
				isPostage, giveIntegral, cost, videoLink, tempId);
		return new JsonResult<Void>(SUCCESS);
	}
	
	@RequestMapping("delete")
	public JsonResult<Void> delPro(String ids){
		productInfoService.delPro(ids);
		return new JsonResult<Void>(SUCCESS);
	}
	
}



