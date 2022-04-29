package com.example.sport.Service.Impl;

import com.example.sport.Bean.RegistrationsBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 18:53
 */
@SpringBootTest
public class RegisterServiceTest {
    @Resource
    RegisterServiceImpl registerService;

    @Test
    public void testInsertGame() {
        RegistrationsBean registrations = new RegistrationsBean(1,1,1,1,9);
        System.out.println(registerService.insertGame(registrations));
    }

    @Test
    public void testDelGame() {
        System.out.println(registerService.delGame(1));
    }

    @Test
    public void testUpdateGame() {
        RegistrationsBean registrations = new RegistrationsBean(1,1,1,0,9);
        System.out.println(registerService.updateGame(registrations));
    }

    @Test
    public void testGetGame() {
        System.out.println(registerService.getGame(1,10));
    }

    @Test
    public void testCountRegister() {
        System.out.println(registerService.countRegister());
    }
}