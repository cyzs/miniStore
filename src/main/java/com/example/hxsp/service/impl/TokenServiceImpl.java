package com.example.hxsp.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.hxsp.bean.UserInfo;
import com.example.hxsp.service.TokenService;

@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService{
	/**
     * 过期时间，单位毫秒
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    public String getToken(UserInfo adminInfo) {

        String token = "";
        // 生成过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        // 将 admin id 保存到 token 里面
        token = JWT.create().withAudience(adminInfo.getUid() + "")
                //过期时间
                .withExpiresAt(date)
                // 以 account 作为 token 的密钥
                .sign(Algorithm.HMAC256(adminInfo.getAccount()));
        return token;
    }

}
