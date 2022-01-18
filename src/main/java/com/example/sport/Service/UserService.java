package com.example.sport.Service;

import com.example.sport.Bean.UserBean;
import com.example.sport.Controller.Registrations;

public interface UserService {
    /**
    * @Description: 用户账号注册
    * @Param: user实体
    * @return: 注册数量
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int Register(UserBean user);


    /**
    * @Description: 运动员报名
    * @Param: enroll报名表
    * @return: 报名成功数量
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int Enroll(Registrations enroll);


}
