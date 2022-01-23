package com.example.sport.Controller;

import com.example.sport.Bean.CollegesBean;
import com.example.sport.Service.CollegesService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/college")
public class Colleges {

    @Autowired
    private CollegesService collegesService;

    @GetMapping("")
    public Map<String, Object> getColleges(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<CollegesBean> colleges = collegesService.getField((int) data.get("page"), (int) data.get("pageSize"));
        return CommonApi.success(colleges, collegesService.countColleges());
    }


    @PostMapping("add")
    public Map<String, Object> insertColleges(@RequestBody CollegesBean data) {
        int id = collegesService.insertField(data);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        if (id == -1) {
            map.put("msg", "学院存在");
            return CommonApi.error(map);
        } else {
            map.put("msg", "添加成功");
            return CommonApi.success(map, 1);
        }

    }


    @PostMapping("update")
    public Map<String, Object> updateColleges(@RequestBody CollegesBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", collegesService.updateField(data));
        return CommonApi.success(map, 1);
    }


    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", collegesService.delField((int) data.get("id")));
    }
}
