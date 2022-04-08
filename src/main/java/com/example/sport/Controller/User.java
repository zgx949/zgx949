package com.example.sport.Controller;

import com.example.sport.Bean.UserBean;
import com.example.sport.Service.UserService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class User {


    @Autowired
    private UserService userService;

    /**
     * @Description: 登录控制器
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @PostMapping("login")
    public Map<String, Object> login(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> res = userService.loginUser(data.get("username").toString(), data.get("password").toString());
            if (res != null) {
                res.put("msg", "登录成功");
//                res.put("token", res.get("uid").toString());
                return CommonApi.success(res, 2);

            } else {
                return CommonApi.error(null, 1);
            }
        } catch (Exception e) {
            return CommonApi.error(null, 1);
        }



    }

    /**
     * @Description: 获取所有用户信息
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @GetMapping("list")
    public Map<String, Object> getUsers(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<UserBean> users = userService.getUser((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(users, userService.countUser());
    }

    /**
     * @Description: 用户注册
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @PostMapping("add")
    public Map<String, Object> insertUser(@RequestBody UserBean data) {
        data.setCreateTime(new Timestamp(new Date().getTime()));
        int id = userService.insertUser(data);
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
        if (id == -1) {
            map.put("msg", "用户已存在");
            return CommonApi.error(map);
        } else {
            map.put("msg", "注册成功");
            return CommonApi.success(map, 1);
        }

    }

    /**
     * @Description: 修改用户信息
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @PostMapping("update")
    public Map<String, Object> updateUser(@RequestBody UserBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", userService.updateUser(data));
        return CommonApi.success(map, 1);
    }


    /**
     * @Description: 删除用户
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", userService.deleteUser((int) data.get("id")));
    }
}
