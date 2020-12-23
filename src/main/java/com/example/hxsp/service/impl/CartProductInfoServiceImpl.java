package com.example.hxsp.service.impl;

import com.example.hxsp.bean.CartProductInfo;
import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.dao.CartProductInfoDao;
import com.example.hxsp.service.CartProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyf
 * 2020/11/14 11:51
 */
@Service
public class CartProductInfoServiceImpl implements CartProductInfoService {
    @Autowired
    private CartProductInfoDao cartProductInfoDao;

    @Override
    public Map<String,Object> selAll(Integer pageNo, Integer pageSize, Integer uid) {
        Map<String, Object> map = new HashMap<>(2);
        PageHelper.startPage(pageNo, pageSize);
        List<CartProductInfo> list = cartProductInfoDao.selAll(uid);
        PageInfo<CartProductInfo> pageInfo = new PageInfo<CartProductInfo>(list);
        map.put("list", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return map;
    }

    @Override
    public void add(CartProductInfo cartProductInfo) {
        cartProductInfoDao.add(cartProductInfo);
    }

    @Override
    public long delete(Integer id) {
        return cartProductInfoDao.delete(id);
    }
}
