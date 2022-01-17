package com.example.sport;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SportApplicationTests {

    @Resource
    private AdminMapper adminMapper;

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
        AdminBean admin = new AdminBean("zgx949","zgx949","郑国相",1,1);
        adminMapper.insert(admin);
        System.out.println(admin.getId());

    }

}
