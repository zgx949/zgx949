package com.example.sport.Service;

import com.example.sport.Bean.RegistrationsBean;

import java.util.List;

public interface RegisterService {
    /**
     * @Description: 增加
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-24
     */
    int insertGame(RegistrationsBean register);


    /**
     * @Description: 删除
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-24
     */
    int delGame(int id);

    /**
     * @Description: 修改
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-24
     */
    int updateGame(RegistrationsBean register);

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-24
     */
    List<RegistrationsBean> getGame(int page, int pageSize);

    int countRegister();
}
