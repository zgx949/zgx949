package com.example.sport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.sport.Mapper")
public class SportApplication {
    /**
     * 小王同学到此一游。。。。。
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SportApplication.class, args);
    }

}
