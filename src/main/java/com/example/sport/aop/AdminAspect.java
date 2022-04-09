package com.example.sport.aop;

import com.alibaba.fastjson.JSON;
import com.example.sport.Annotation.Admin;
import com.example.sport.Utils.HttpContextUtils;
import com.example.sport.Utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class AdminAspect {

    @Pointcut("@annotation(com.example.sport.Annotation.Admin))")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        recordLog(joinPoint, time);

        return proceed;
    }

    private void recordLog(ProceedingJoinPoint joinPoint,long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Admin admin = method.getAnnotation(Admin.class);
        log.info("=====================log start===============");
        log.info("operator:{}", admin.operator());

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}", className + "." + methodName + "()");
        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        log.info("params:{}", params);
        //获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IpUtil.getIpAddr(request));

        log.info("execute time : {} ms", time);
        log.info("=====================log end===============");
    }

}
