package com.example.sport.Controller;

import com.example.sport.Annotation.Log;
import com.example.sport.Annotation.TokenRequired;
import com.example.sport.Bean.ItemBean;
import com.example.sport.Service.ItemService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class Item {

    @Autowired
    private ItemService itemsService;

    @GetMapping("")
    public Map<String, Object> getItem(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormatter.pageParams(params);
        int parentId = -1;
        try {
            parentId = Integer.parseInt(params.get("parentId").toString());
        } catch (Exception ignored){}

        // 分页查询
        List<ItemBean> items = itemsService.getItem((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(items, itemsService.countItem());
    }


    @TokenRequired
    @Log
    @PostMapping("add")
    public Map<String, Object> insertItem(@RequestBody ItemBean data) {
        return CommonApi.success("successCount", itemsService.insertItem(data));
    }


    @TokenRequired
    @Log
    @PostMapping("update")
    public Map<String, Object> updateItem(@RequestBody ItemBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", itemsService.updateItem(data));
        return CommonApi.success(map, 1);
    }


    @TokenRequired
    @Log
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", itemsService.delItem((int) data.get("id")));
    }


}
