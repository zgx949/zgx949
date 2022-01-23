package com.example.sport.Controller;

import com.example.sport.Bean.GamesBean;
import com.example.sport.Service.GamesService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class Games {

    @Autowired
    private GamesService gamesService;

    @GetMapping("")
    public Map<String, Object> getGames(@RequestParam Map<String, Object> params) {
        // 解析页面分页参数
        Map<String, Object> data = ParamsFormater.pageParams(params);

        // 分页查询
        List<GamesBean> games = gamesService.getField((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(games, gamesService.countGames());
    }


    @PostMapping("add")
    public Map<String, Object> insertGames(@RequestBody GamesBean data) {
        int id = gamesService.insertField(data);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        if (id == -1) {
            map.put("msg", "用户已存在");
            return CommonApi.error(map);
        } else {
            map.put("msg", "添加成功");
            return CommonApi.success(map, 1);
        }

    }


    @PostMapping("update")
    public Map<String, Object> updateGames(@RequestBody GamesBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", gamesService.updateField(data));
        return CommonApi.success(map, 1);
    }



    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", gamesService.delField((int) data.get("id")));
    }
}
