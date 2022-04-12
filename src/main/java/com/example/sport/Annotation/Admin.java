package com.example.sport.Annotation;

import java.lang.annotation.*;

/**
 * @Description: 记录管理员的add操作
 * @Param: time、ip、operator、username
 * @Author: 松柏
 * @Date: 2022-04-08
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Admin {

    String operator() default "";

}
