package com.example.hxsp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderNumUtil {

    /**
     * 随机生成订单号
     * @return
     */
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<5;i++){
            result+=random.nextInt(10);
        }
        return "NO"+newDate+result;
    }
}
