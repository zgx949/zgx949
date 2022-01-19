package com.example.sport.Controller;

import com.example.sport.Bean.AdminBean;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class Admin {


    @Autowired
    private AdminService adminService;

    /**
     * @Description: 登录控制器
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    @PostMapping("login")
    public Map<String, Object> login(@RequestBody Map<String, Object> data) {

        Map<String, Object> res = adminService.loginAdmin(data.get("username").toString(), data.get("password").toString());
        if (res != null) {
            res.put("res", "登录成功");
            return CommonApi.success(res, 2);
        } else {
            return CommonApi.error(null, 1);
        }

    }

    /**
     * @Description: 获取所有管理员信息
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    @GetMapping("list")
    public Map<String, Object> getAdmins(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<AdminBean> admins = adminService.getAdmin((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(admins, admins.size());
    }

    /**
    * @Description: 管理员注册
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    @PostMapping("add")
    public Map<String, Object> insertAdmin(@RequestBody AdminBean data) {
        int id = adminService.insertAdmin(data);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        if (id == -1) {
            map.put("msg", "用户已存在");
            return CommonApi.error(map);
        } else {
            map.put("msg", "注册成功");
            return CommonApi.success(map, 1);
        }

    }

    /**
    * @Description: 修改管理员信息
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    @PostMapping("update")
    public Map<String, Object> updateAdmin(@RequestBody AdminBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("修改成功数量", adminService.updateAdmin(data));
        return CommonApi.success(map, 1);
    }


    /**
    * @Description: 删除管理员
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        // 获取参数
        int id = (int) data.get("id");

        int delCount = adminService.deleteAdmin(id);
        return CommonApi.success(delCount > 0? "删除成功": "查无此人", 1);
    }
}
