package com.example.hxsp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hxsp.service.CallbackService;


/**
 * 支付回调
 */
@Slf4j
@RestController
@RequestMapping("hxsp/payment/callback")
public class CallbackController {

    @Autowired
    private CallbackService callbackService;

    /**
     * 微信支付回调
     * @author Mr.Zhang
     * @since 2020-05-06
     */
    @RequestMapping(value = "/wechat", method = RequestMethod.POST)
    public void weChat(@RequestBody String  request) {
        //微信支付回调
        try{
            if(callbackService.weChat(request)){
                System.out.println("<xml>\n" +
                        "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                        "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                        "</xml>");
            }
        }catch (Exception e){
            System.out.println("<xml>\n" +
                    "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                    "  <return_msg><![CDATA["+e.getMessage()+"]]></return_msg>\n" +
                    "</xml>");
        }

    }

}



