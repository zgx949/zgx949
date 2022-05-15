package com.example.sport.Controller;

import com.example.sport.Annotation.Log;
import com.example.sport.Bean.FieldsBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Service.FieldsService;
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
@RequestMapping("/field")
public class Fields {

    @Autowired
    private FieldsService fieldsService;

    @GetMapping("")
    public Map<String, Object> getFields(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormatter.pageParams(params);
        int parentId = -1;
        try {
            parentId = Integer.parseInt(params.get("parentId").toString());
        } catch (Exception ignored){}

        // 分页查询
        List<FieldsBean> fields = fieldsService.getField(parentId, (int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(fields, fieldsService.countFields());
    }


    @TokenRequired
    @Log
    @PostMapping("add")
    public Map<String, Object> insertFields(@RequestBody FieldsBean data) {
        return CommonApi.success("successCount", fieldsService.insertField(data));
    }


    @TokenRequired
    @Log
    @PostMapping("update")
    public Map<String, Object> updateFields(@RequestBody FieldsBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", fieldsService.updateField(data));
        return CommonApi.success(map, 1);
    }


    @TokenRequired
    @Log
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", fieldsService.delField((int) data.get("id")));
    }

    @GetMapping("tree")
    public List<Map<String, Object>> getTree() {
        return fieldsService.fieldTree();
    }

    @GetMapping("options")
    public List<menuOptionsBean> getOptions() {
        return fieldsService.fieldOptions();
    }
}
