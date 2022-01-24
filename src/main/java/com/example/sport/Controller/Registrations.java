package com.example.sport.Controller;

import com.example.sport.Bean.RegistrationsBean;
import com.example.sport.Service.RegisterService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class Registrations {

    @Autowired
    private RegisterService registerService;

    @GetMapping("")
    public Map<String, Object> getRegistrations(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<RegistrationsBean> register = registerService.getGame((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(register, registerService.countRegister());
    }


    @PostMapping("add")
    public Map<String, Object> insertRegistrations(@RequestBody RegistrationsBean data) {
        data.setCreateTime(new Timestamp(new Date().getTime()));
        return CommonApi.success("successCount", registerService.insertGame(data));

    }


    @PostMapping("update")
    public Map<String, Object> updateRegistrations(@RequestBody RegistrationsBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", registerService.updateGame(data));
        return CommonApi.success(map, 1);
    }



    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", registerService.delGame((int) data.get("id")));
    }
}
