package com.example.hxsp.service.impl;

import com.aliyun.oss.ServiceException;
import com.example.hxsp.service.CallbackService;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 支付类
 */
@EqualsAndHashCode()
@Data
@Service
public class CallbackServiceImpl implements CallbackService {
    private static final Logger log = LoggerFactory.getLogger(CallbackServiceImpl.class);

    /**
     * 微信支付回调
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class, ServiceException.class})
    public boolean weChat(String request) {
        try{
        	
        	return false;
        }catch (Exception e){
            return false;
        }
    }

}
