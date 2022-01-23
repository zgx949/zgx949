package com.example.sport.Service;

import com.example.sport.Bean.CollegesBean;

import java.util.List;

public interface CollegesService {
    /**
     * @Description: 增加
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int insertField(CollegesBean field);


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
    int updateField(CollegesBean field);

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    List<CollegesBean> getField(int page, int pageSize);

    int countColleges();
}
