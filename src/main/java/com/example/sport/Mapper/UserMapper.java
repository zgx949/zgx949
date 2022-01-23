package com.example.sport.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sport.Bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserBean> {
}
