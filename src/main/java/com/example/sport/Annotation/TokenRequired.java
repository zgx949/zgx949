package com.example.sport.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* @Description: 管理员Token验证注解定义
* @Param:
* @return:
* @Author: 左手
* @Date: 2022-02-13
*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenRequired {
    boolean required() default true;
}
