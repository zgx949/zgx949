package com.example.sport.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sport.Bean.AdminBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Mapper
public interface AdminMapper extends BaseMapper<AdminBean> {

    /**
    * @Description: 自定义sql查询（非必要）
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-14
    */
    @Select({"${sql}"})
    @ResultType(ArrayList.class)
    List<AdminBean> executeQuery(@Param("sql") String sql);

}
