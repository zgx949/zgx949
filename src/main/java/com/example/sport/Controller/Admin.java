package com.example.sport.Controller;

import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormatter;
import com.example.sport.Annotation.TokenRequired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@Api(value = "管理员", tags = "管理员登录注册")
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
    @ApiOperation(value = "管理员登录", notes = "管理员登录", httpMethod = "POST")
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
    @ApiOperation(value = "管理员列表", notes = "获取所有管理员的信息", httpMethod = "GET")
    @TokenRequired
    public Map<String, Object> getAdmins(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormatter.pageParams(params);

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
    @ApiOperation(value = "管理员注册", notes = "注册一个新的管理员并赋权限", httpMethod = "POST")
    @TokenRequired
    public Map<String, Object> insertAdmin(@RequestBody AdminBean data) {
        System.out.println("请求");
        int id = adminService.insertAdmin(data);
        System.out.println(id);
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
    @ApiOperation(value = "管理员信息修改", notes = "修改管理员的信息", httpMethod = "POST")
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
    @ApiOperation(value = "删除管理员", notes = "根据ID删除管理员用户", httpMethod = "POST")
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
