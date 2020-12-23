package com.example.hxsp.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hxsp.bean.ProductCategory;
import com.example.hxsp.service.ProductCategoryService;
import com.example.hxsp.utils.JsonResult;



/**
 * 分类表 
 */
@Slf4j
@RestController
@RequestMapping("hxsp/category")
public class ProductCategoryController extends BaseController{

	@Autowired
	private ProductCategoryService productCategoryService;

	/**
	 * 获取该级的次级目录
	 * @param pid 父级id
	 * @return
	 */
	@RequestMapping("contents")
	public JsonResult<List<ProductCategory>> getContentsByPid(Integer pid){
		return new JsonResult<List<ProductCategory>>(SUCCESS, productCategoryService.findContentsByPid(pid));
	}
	
}



