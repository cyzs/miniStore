package com.example.hxsp.dao;

import com.example.hxsp.bean.CartInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartInfoDao {
    /**
     * 查询所有
     * @return
     */
    public List<CartInfo> selAll();

    /**
     * 根据用户id查询购物车id
     * @param uid
     * @return
     */
    public CartInfo selOne(Integer uid);

    /**
     * 添加用户购物车
     * @param cartInfo
     */
    public void add(CartInfo cartInfo);

}
