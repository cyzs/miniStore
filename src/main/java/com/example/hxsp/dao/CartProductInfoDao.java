package com.example.hxsp.dao;

import com.example.hxsp.bean.CartProductInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cyf
 * 2020/11/14 11:25
 */
@Repository
public interface CartProductInfoDao {
    /**
     * 查询用户的购物车商品
     * @return
     */
    public List<CartProductInfo> selAll(Integer uid);

    /**
     * 添加购物车商品关系
     * @param cartProductInfo
     */
    public void add(CartProductInfo cartProductInfo);

    /**
     * 移除购物车商品
     * @param id
     * @return
     */
    long delete(Integer id);
}
