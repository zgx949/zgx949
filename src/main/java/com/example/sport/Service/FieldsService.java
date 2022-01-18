package com.example.sport.Service;

import com.example.sport.Bean.FieldsBean;

import java.util.List;

public interface FieldsService {
    /**
    * @Description: 增加
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int insertField(FieldsBean field);


    /**
    * @Description: 删除
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int delField(int id);

    /**
    * @Description: 修改
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int updateField(FieldsBean field);

    /**
    * @Description: 查询
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    List<FieldsBean> getField(int page, int pageSize);
}
