package com.example.hxsp.controller;

import com.example.hxsp.service.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hxsp.utils.JsonResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 控制器的基类
 */
@Slf4j
public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * 响应成功的标识码
     */
    public static final int SUCCESS = 2000;

    /**
     * 处理异常
     */
    @ExceptionHandler({ServiceException.class, Exception.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> res = new JsonResult<Void>(e);
        if (e instanceof OutOfStockException) {
            // 4001 库存不足异常
            res.setState(4001);
        }
        if (e instanceof NonExistException) {
            res.setState(4002);
        } else if (e instanceof CouponAlreadyRevException) {
            res.setState(4003);
        } else if (e instanceof WrongDataException) {
            res.setState(4005);
        } else {
            // 5000-程序错误
            res.setState(5000);
            logger.error("出现异常，请联系管理员{}", e);
        }

        return res;

    }
}
