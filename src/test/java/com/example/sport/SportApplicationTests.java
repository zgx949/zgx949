package com.example.sport;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.MenusBean;
import com.example.sport.Mapper.AdminMapper;
import com.example.sport.Mapper.MenusMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SportApplicationTests {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private MenusMapper menusMapper;


    @Test
    void contextLoads() {
        // 条件查询
        AdminBean admin = new AdminBean();
        admin.setName("test");
        List<AdminBean> adminlist = adminMapper.selectList(new QueryWrapper<>(admin));
        System.out.println(adminlist);

    }
    @Test
    void insertAdmin() {
        // 插入一个admin
        AdminBean admin = new AdminBean("ss","zgx949","郑国相",1,1);
        adminMapper.insert(admin);
        System.out.println(admin.getId());

    }
    @Test
    void adminLogin() {
        // 获取菜单
        QueryWrapper<MenusBean> queryWrapperMenu = new QueryWrapper<>();
        queryWrapperMenu.eq("level_id", "1");
        List<MenusBean> menus = menusMapper.selectList(queryWrapperMenu);
        System.out.println(menus);
    }

    @Test
    void getAdmins() {
        List<AdminBean> result = new ArrayList<>();
        result = adminMapper.selectList(null);
        System.out.println(result);
    }
    @Test
    void exitAdmin() {
        QueryWrapper<AdminBean> queryWrapperAdmin = new QueryWrapper<>();
        queryWrapperAdmin.eq("username", "zxzxzccc");
        System.out.println(adminMapper.selectCount(queryWrapperAdmin));
    }
    @Test
    public void dynamicsUpdate() {

        adminMapper.executeQuery("SELECT admin.id, admin.username, admin.password, admin.name, admin.level, colleges.name as 'college'  FROM admin LEFT JOIN JOIN colleges ON colleges.id=admin.college_id LIMIT 5 OFFSET 0")
                .forEach(System.out::println);

    }

}
