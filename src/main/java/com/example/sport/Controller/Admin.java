package com.example.sport.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Mapper.AdminMapper;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.CommonApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class Admin {

    @Autowired
    private AdminMapper adminMapper;

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody Map<String, Object>data) {
        AdminBean admin = new AdminBean();
        String username = data.get("username").toString();
        admin.setUsername(username);
        System.out.println(username);

        List<AdminBean> adminBeanList = adminMapper.selectByMap(data);
        System.out.println(adminBeanList);
        data.put("data", adminBeanList);

        return CommonApi.success(data);
    }
}
