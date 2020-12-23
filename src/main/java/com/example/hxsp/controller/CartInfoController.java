package com.example.hxsp.controller;

import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hxsp.service.CartInfoService;
import com.example.hxsp.utils.JsonResult;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 购物车表 
 */
@Slf4j
@RestController
@RequestMapping("hxsp/cart")
public class CartInfoController extends BaseController{

	@Autowired
	private CartInfoService cartInfoService;
	
	/**
	 * 新增购物车表
	 * @param uid 用户id
	 * @param proId 商品id
	 * @return
	 */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonResult<Void> save(String uid, Integer proId){
    	cartInfoService.saveCart(uid, proId);
    	return new JsonResult<>(SUCCESS);
    	
    }
}
