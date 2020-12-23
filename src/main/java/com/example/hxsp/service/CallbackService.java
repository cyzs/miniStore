package com.example.hxsp.service;

/**
 * 订单支付
 *
 */
public interface CallbackService {
    boolean weChat(String request) throws Exception;
}
