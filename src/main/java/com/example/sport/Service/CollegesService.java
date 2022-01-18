package com.example.sport.Service;

import com.example.sport.Bean.CollegesBean;

import java.util.List;

public interface CollegesService {
    /**
     * @Description: 增加一个学院
     * @Param: 学院信息实体
     * @return: 增加个数
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int insertCollege(CollegesBean college);

    /**
     * @Description: 删除一个学院信息
     * @Param: id
     * @return: 删除个数
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int delCollege(int id);

    /**
     * @Description: 修改学院信息
     * @Param: 实体
     * @return: 修改的个数
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int updateCollege(CollegesBean college);

    /**
     * @Description: 分页获取学院信息
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    List<CollegesBean> getColleges(int page, int pageSize);
}
