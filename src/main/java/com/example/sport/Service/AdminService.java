package com.example.sport.Service;

import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.MenusBean;
import com.example.sport.Bean.menuOptionsBean;

import java.util.List;
import java.util.Map;

public interface AdminService {

    /**
     * @Description: 验证登录
     * @Param: username 用户名
     * @Param: password 密码
     * @return: 登录是否成功
     * @Author: 左手
     * @Date: 2022-01-18
     */
    Map<String, Object> loginAdmin(String username, String password);

    /**
     * @Description: 根据管理员等级来获取对应菜单的路径
     * @Param: levelId 管理员等级
     * @return: List<MenusBean> 菜单列表
     * @Author: 左手
     * @Date: 2022-01-18
     */
    List<Object> getMenu(int levelId);


    /**
     * @Description:
     * @Param: Map<String, Object> admin实体
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int insertAdmin(AdminBean admin);


    /**
     * @Description: 通过ID删除管理员账号
     * @Param: int id
     * @return: 删除个数
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int deleteAdmin(int id);


    /**
     * @Description: 通过ID修改管理员信息接口
     * @Param: Map<String, Object> admin 实体
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int updateAdmin(AdminBean admin);


    /**
     * @Description: 获取管理员用户列表（分页）接口
     * @Param: int page 页数
     * @Param: int pageSize 页面大小
     * @return: AdminBean
     * @Author: 左手
     * @Date: 2022-01-18
     */
    List<AdminBean> getAdmin(int page, int pageSize);


    int countAdmin();

    /**
    * @Description: 是否存在该用户
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-20
    */
    boolean exitAdmin(String username);

    /**
    * @Description: 获取菜单的选项映射
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-28
    */
    List<menuOptionsBean> adminOptions();

    /**
    * @Description: 根据ID查询管理员
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-02-13
    */
    AdminBean findAdminById(int id);
}
