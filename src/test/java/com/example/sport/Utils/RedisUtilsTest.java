package com.example.sport.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: sport
 * @description: Redis工具测试类
 * @author: LeftHand
 * @create: 2022-03-27 20:17
 **/
@SpringBootTest
public class RedisUtilsTest {
    @Autowired
    RedisUtils redisUtils;
    @Test
    public void setTest() {
        redisUtils.set("testJson", "{\"msg\": \"ok\"}");
    }

    @Test
    public void getTest() {
        redisUtils.get("testJson");
    }


}
