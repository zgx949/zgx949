package com.example.sport.aop;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.HttpContextUtils;
import com.example.sport.Utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    AdminService adminService;

    /**
     * 1. TODO: 这里可以加一个线程池做异步~~ 效果更佳哦
     * 2. TODO: 还缺少一个异常捕获的日志
     * 3. TODO: 记录在哪里，可视化界面的制作等等
     */

    /**
     * 切点
     */
    @Pointcut("@annotation(com.example.sport.Annotation.Log))")
    public void pt(){}

    /**
     * 切面
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        recordLog(joinPoint, time);

        return proceed;
    }

    /**
     * 获取日志基本信息的公共方法
     * @param joinPoint
     * @param time
     */
    private void recordLog(ProceedingJoinPoint joinPoint,long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // Article article = method.getAnnotation(Article.class);
        log.info("=====================log start===============");
        // 获取request
        HttpServletRequest req = (HttpServletRequest) RequestContextHolder.getRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);

        String token = req.getHeader("token");
        DecodedJWT decodeToken = JWT.decode(token);
        String username = decodeToken.getClaim("username").asString();
        String id = decodeToken.getClaim("id").asString();
        log.info("id:{},admin:{}", id, username);
        // log.info("operator:{}", article.operator());

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("operation:{}", className + "." + methodName + "()");
        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        log.info("params:{}", params);
        //获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IpUtil.getIpAddr(request));
        log.info("cost time:{}",time);

        log.info("=====================log end===============");
    }

}
