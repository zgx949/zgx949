package com.example.sport.Controller;

import com.example.sport.Annotation.Log;
import com.example.sport.Bean.CollegesBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Service.CollegesService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormatter;
import com.example.sport.Annotation.TokenRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/colleges")
public class Colleges {

    @Autowired
    private CollegesService collegesService;

    @GetMapping("")
    @TokenRequired
    public Map<String, Object> getColleges(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormatter.pageParams(params);

        // 分页查询
        List<CollegesBean> colleges = collegesService.getCollege((int) data.get("page"), (int) data.get("pageSize"));
        return CommonApi.success(colleges, collegesService.countColleges());
    }


    @PostMapping("add")
    @Log
    @TokenRequired
    public Map<String, Object> insertColleges(@RequestBody CollegesBean data) {
        return CommonApi.success("successCount", collegesService.insertCollege(data));
    }

    @TokenRequired
    @Log
    @PostMapping("update")
    public Map<String, Object> updateColleges(@RequestBody CollegesBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", collegesService.updateField(data));
        return CommonApi.success(map, 1);
    }

    @TokenRequired
    @Log
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", collegesService.delCollege((int) data.get("id")));
    }

    @GetMapping("options")
    public List<menuOptionsBean> getOptions() {
        return collegesService.collegesOptions();
    }
}
