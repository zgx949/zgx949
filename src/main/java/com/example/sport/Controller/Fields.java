package com.example.sport.Controller;

import com.example.sport.Bean.FieldsBean;
import com.example.sport.Service.FieldsService;
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
@RequestMapping("/field")
public class Fields {

    @Autowired
    private FieldsService fieldsService;

    @GetMapping("")
    public Map<String, Object> getFields(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<FieldsBean> fields = fieldsService.getField((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(fields, fieldsService.countFields());
    }


    @PostMapping("add")
    public Map<String, Object> insertFields(@RequestBody FieldsBean data) {
        return CommonApi.success("successCount", fieldsService.insertField(data));
    }


    @PostMapping("update")
    public Map<String, Object> updateFields(@RequestBody FieldsBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", fieldsService.updateField(data));
        return CommonApi.success(map, 1);
    }



    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", fieldsService.delField((int) data.get("id")));
    }
}
