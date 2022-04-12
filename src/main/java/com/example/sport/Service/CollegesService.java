package com.example.sport.Service;

import com.example.sport.Bean.CollegesBean;
import com.example.sport.Bean.menuOptionsBean;

import java.util.List;

public interface CollegesService {
    /**
     * @Description: 增加
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int insertCollege(CollegesBean college);


    /**
     * @Description: 删除
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int delCollege(int id);

    /**
     * @Description: 修改
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int updateField(CollegesBean field);

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    List<CollegesBean> getCollege(int page, int pageSize);

    int countColleges();

    List<menuOptionsBean> collegesOptions();
}
