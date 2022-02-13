package com.example.sport.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: sport
 * @description: 拦截器配置
 * @author: 左手
 * @create: 2022-02-13 14:15
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将我们上步定义的实现了HandlerInterceptor接口的拦截器实例authenticationInterceptor添加InterceptorRegistration中，并设置过滤规则，所有请求都要经过authenticationInterceptor拦截。
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }
}
