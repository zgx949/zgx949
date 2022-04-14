package com.example.sport.Service.Impl;

import com.example.sport.Bean.AdminBean;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testGetMenu() {
        // TODO: 未测试线程安全情况
        for (int i = 0; i < 5; i++) {
            System.out.println(adminService.getMenu(i));
        }
    }

    @Test
    public void testExists() {
        System.out.println(adminService.existsAdmin("admin"));
    }

    @Test
    public void testInsertAdmin() {
        AdminBean admin = new AdminBean("admin", "admin", "测试管理员", 0, 0);
        System.out.println(adminService.insertAdmin(admin));
    }

    @Test
    public void testUpdateAdmin() {
        AdminBean admin = new AdminBean("admin", "adminupdate", "测试修改管理员", 0, 0);
        System.out.println();
    }

    @Test
    public void testDeleteAdmin() {
        System.out.println(adminService.deleteAdmin(10));
    }

    @Test
    public void testGetAdmin() {
        System.out.println(adminService.getAdmin(1, 10));
    }

    @Test
    public void testCountAdmin() {
        System.out.println(adminService.countAdmin());
    }

    @Test
    public void testAdminOptions() {
        System.out.println(adminService.adminOptions());
    }

    @Test
    public void testFindAdminById() {
        System.out.println(adminService.findAdminById(1));
    }

}
