package com.example.sport.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sport.Bean.AdminBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface AdminMapper extends BaseMapper<AdminBean> {
//    List<AdminBean> select(Map<String, Object> adminMap);
}
