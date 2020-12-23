package com.example.hxsp.controller;

import com.example.hxsp.bean.CartProductInfo;
import com.example.hxsp.service.CartProductInfoService;
import com.example.hxsp.utils.JsonResult;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author cyf
 * 2020/11/14 12:31
 */
@RestController
@RequestMapping("hxsp/cartProductInfo")
public class CartProductInfoController extends BaseController {
    @Autowired
    private CartProductInfoService cartProductInfoService;

    /**
     * 查询用户购物车商品
     * @param pageNo
     * @param pageSize
     * @param uid
     * @return
     */
    @RequestMapping(value = "/selAll", method = RequestMethod.GET)
    public JsonResult<Map<String,Object>> selAll(Integer pageNo,Integer pageSize,Integer uid){
        return new JsonResult<Map<String,Object>>(SUCCESS,cartProductInfoService.selAll(pageNo,pageSize,uid));
    }


    /**
     * 添加购物车商品
     * @param cartProductInfo
     * @return
     */
    @RequestMapping("add")
    public JsonResult<Void> add(CartProductInfo cartProductInfo) {
       cartProductInfoService.add(cartProductInfo);
        return new JsonResult<>(SUCCESS);
    }


}
