package com.example.sport.Service;

import com.example.sport.Bean.AdminBean;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<AdminBean> select(Map<String, Object> adminMap);
}
