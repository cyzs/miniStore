package com.example.hxsp.service;


 /**
 * 订单任务服务
 */
 public interface OrderTaskService{

     void cancelByUser();

     void refundApply();

     void complete();

     void takeByUser();

     void deleteByUser();
 }
