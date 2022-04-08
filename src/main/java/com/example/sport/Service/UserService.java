package com.example.sport.Service;

import com.example.sport.Bean.UserBean;
import com.example.sport.Bean.MenusBean;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * @Description: 验证登录
     * @Param: username 用户名
     * @Param: password 密码
     * @return: 登录是否成功
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    Map<String, Object> loginUser(String username, String password);



    /**
     * @Description:
     * @Param: Map<String, Object> User实体
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int insertUser(UserBean User);


    /**
     * @Description: 通过ID删除用户账号
     * @Param: int id
     * @return: 删除个数
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int deleteUser(int id);


    /**
     * @Description: 通过ID修改用户信息接口
     * @Param: Map<String, Object> User 实体
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int updateUser(UserBean User);


    /**
     * @Description: 获取用户用户列表（分页）接口
     * @Param: int page 页数
     * @Param: int pageSize 页面大小
     * @return: UserBean
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    List<UserBean> getUser(int page, int pageSize);


    int countUser();

    /**
     * @Description: 是否存在该用户
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-20
     */
    boolean exitUser(String username);

    /**
    * @Description: 通过ID查询用户
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-13
    */
    UserBean findUserById(int id);
}
