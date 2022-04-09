package com.example.sport.Controller;

import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import com.example.sport.Annotation.TokenRequired;
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
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @PostMapping("login")
    @com.example.sport.Annotation.Admin(operator = "login")
    public Map<String, Object> login(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> res = adminService.loginAdmin(data.get("username").toString(), data.get("password").toString());
            if (res != null) {
                res.put("msg", "登录成功");
                return CommonApi.success(res, 2);

            } else {
                return CommonApi.error(null, 1);
            }
        } catch (Exception e) {
            return CommonApi.error(null, 1);
        }



    }

    /**
     * @Description: 获取所有管理员信息
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    @GetMapping("list")
    @TokenRequired
    public Map<String, Object> getAdmins(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<AdminBean> admins = adminService.getAdmin((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(admins, adminService.countAdmin());
    }

    /**
    * @Description: 管理员注册
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    @PostMapping("add")
    @TokenRequired
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
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    @PostMapping("update")
    @TokenRequired
    public Map<String, Object> updateAdmin(@RequestBody AdminBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("修改成功数量", adminService.updateAdmin(data));
        return CommonApi.success(map, 1);
    }


    /**
    * @Description: 删除管理员
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    @PostMapping("delete")
    @TokenRequired
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", adminService.deleteAdmin((int) data.get("id")));
    }

    /**
    * @Description: 获取名字与ID的映射
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-14
    */
    @GetMapping("options")
    @TokenRequired
    public List<menuOptionsBean> getOptions() {
        return adminService.adminOptions();
    }
}
