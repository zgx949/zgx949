package com.example.sport.Service.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: sport
 * @description: Admin管理员业务测试类
 * @author: LeftHand
 * @create: 2022-04-08 19:21
 **/
@SpringBootTest
public class AdminServiceTest {
    @Resource
    AdminServiceImpl adminService;

    @Test
    public void testLoginAdmin() {
        Map<String, Object> result = adminService.loginAdmin("admin", "111111");
        if (result == null) {
            System.out.println("账号密码错误");
        }
        System.out.println(result);
    }

}
