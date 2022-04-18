package com.example.sport.Annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Param: time、ip、operator、username
 * @Author: songbai
 * @Date: 2022-04-08
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    // String operator() default "";

}
