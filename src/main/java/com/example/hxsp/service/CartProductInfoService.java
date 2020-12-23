package com.example.hxsp.service;

import com.example.hxsp.bean.CartProductInfo;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;


/**
 * @author cyf
 * 2020/11/14 11:50
 */
public interface CartProductInfoService {

    /**
     * 查询用户的购物车商品
     * @return
     */
    Map<String,Object> selAll(Integer pageNo, Integer pageSize, Integer uid);

    /**
     * 添加购物车商品关系
     * @param cartProductInfo
     */
    void add(CartProductInfo cartProductInfo);

    /**
     * 移除购物车商品
     * @param id
     * @return
     */
    long delete(Integer id);


}
