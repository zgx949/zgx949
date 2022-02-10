package com.example.sport.Controller;

import com.example.sport.Bean.NumsBean;
import com.example.sport.Service.NumsService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/nums")
public class Nums {

    @Autowired
    private NumsService numsService;

    @GetMapping("")
    public Map<String, Object> getNums(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<NumsBean> nums = numsService.getNum((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(nums, numsService.countNums());
    }


    @PostMapping("add")
    public Map<String, Object> insertNums(@RequestBody NumsBean data) {
//        data.setCreateTime(new Timestamp(new Date().getTime()));
        return CommonApi.success("successCount", numsService.insertNum(data));

    }


    @PostMapping("update")
    public Map<String, Object> updateNums(@RequestBody NumsBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", numsService.updateNum(data));
        return CommonApi.success(map, 1);
    }



    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", numsService.delNum((int) data.get("id")));
    }
}
