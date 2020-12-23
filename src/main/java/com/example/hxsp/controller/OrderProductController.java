package com.example.hxsp.controller;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.OrderProduct;
import com.example.hxsp.service.OrderProductService;
import com.example.hxsp.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("hxsp/orderProduct")
@RestController
public class OrderProductController extends BaseController  {

    @Autowired
    private OrderProductService orderProductService;

    /**
     * 查询订单商品列表
     * @param id
     * @return
     */
    @RequestMapping("/sel")
    public JsonResult<List<OrderProduct>> sel(Integer id){
        return new JsonResult<List<OrderProduct>>(SUCCESS,orderProductService.list(id));
    }


}
