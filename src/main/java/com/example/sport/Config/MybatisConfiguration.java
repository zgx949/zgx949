package com.example.sport.Config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: sport
 * @description: 分页拦截器
 * @author: LeftHand
 * @create: 2022-01-19 15:09
 **/

@Configuration
public class MybatisConfiguration {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 分页配置
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}

