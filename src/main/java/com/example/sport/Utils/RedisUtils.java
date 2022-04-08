package com.example.sport.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: sport
 * @description: 操作Redis
 * @author: LeftHand
 * @create: 2022-02-17 18:44
 **/
@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
    * @Description: 读取缓存
    * @Param: key
    * @return:
    * @Author: LeftHand
    * @Date: 2022-03-27
    */
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
    * @Description: 写入缓存
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-03-27
    */
    public boolean set(String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
    * @Description: 更新缓存
    * @Param: key: String
    * @Param: value: String
    * @return:
    * @Author: LeftHand
    * @Date: 2022-03-27
    */
    public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     */
    /**
    * @Description: 删除缓存
    * @Param: key: String
    * @return:
    * @Author: LeftHand
    * @Date: 2022-03-27
    */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
