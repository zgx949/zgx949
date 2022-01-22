package com.example.sport.Controller;

import com.example.sport.Bean.AdminBean;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/field")
public class Fields {

    @Autowired
    private AdminService adminService;

    @GetMapping("")
    public Map<String, Object> getAdmins(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<AdminBean> admins = adminService.getAdmin((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(admins, adminService.countAdmin());
    }


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


    @PostMapping("update")
    public Map<String, Object> updateAdmin(@RequestBody AdminBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("修改成功数量", adminService.updateAdmin(data));
        return CommonApi.success(map, 1);
    }



    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success(adminService.deleteAdmin((int) data.get("id")) > 0? "删除成功": "查无此人", 1);
    }
}
