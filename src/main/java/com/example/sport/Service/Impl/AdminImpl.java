package com.example.sport.Service.Impl;

import com.example.sport.Bean.AdminBean;
import com.example.sport.Mapper.AdminMapper;
import com.example.sport.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminBean> select(Map<String, Object> adminMap) {
        return null;
    }
//    @Override
//    public List<AdminBean> select(Map<String, Object> adminMap) {
////        return adminMapper.select(adminMap);
//    }
}
