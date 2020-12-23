package com.example.hxsp.utils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @InterfaceName PassToken
 * @Description TODO
 * @Author Zoran
 * @CreateDate 2020年05月25日  15:42:06
 * @Version 1.0.0
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
