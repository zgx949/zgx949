package com.example.sport.Service.Impl;

import com.example.sport.Bean.UserBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Map;


/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 19:00
 */
@SpringBootTest
public class UserServiceTest {
    @Resource
    UserServiceImpl userService;

    @Test
    public void testFindUserById() {
        System.out.println(userService.findUserById(1));
    }

    @Test
    public void testLoginUser() {
        Map<String, Object> result = userService.loginUser("xiaowang","123456");
        if (result == null) {
            System.out.println("账号密码错误");
        }
        System.out.println(result);
    }

    @Test
    public void testExitUser() {
        System.out.println(userService.exitUser("xiaowang"));
    }

    @Test
    public void testInsertUser() {
        Timestamp time = Timestamp.valueOf("2022-04-15 18:18:00");
        UserBean user = new UserBean(3,"xiaowang","123456","小王同学",1,1,time,1);
        System.out.println(userService.insertUser(user));
    }

    @Test
    public void testDeleteUser() {
        System.out.println(userService.deleteUser(7));
    }

    @Test
    public void testUpdateUser() {
        Timestamp time = Timestamp.valueOf("2022-04-15 10:18:00");
        UserBean user = new UserBean(3,"xiaowang","123456","小王同学",1,1,time,1);
        System.out.println(userService.updateUser(user));
    }

    @Test
    public void testGetUser() {
        System.out.println(userService.getUser(1,10));
    }

    @Test
    public void testCountUser() {
        System.out.println(userService.countUser());
    }
}