package com.example.hxsp.bean;

/**
 * @ClassName AccessToken
 * @Description TODO
 * @Author Zoran
 * @CreateDate 2020年05月25日  15:37:36
 * @Version 1.0.0
 */

public class AccessToken {

    /**
     * 接口访问凭证
     */
    private String token;
    /**
     * 凭证有效期，单位：秒
     */
    private int expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
