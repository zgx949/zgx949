package com.example.sport.Controller;

import com.example.sport.Annotation.Log;
import com.example.sport.Bean.GamesBean;
import com.example.sport.Service.GamesService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormatter;
import com.example.sport.Annotation.TokenRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
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
        Map<String, Object> data = ParamsFormatter.pageParams(params);

        // 分页查询
        List<GamesBean> games = gamesService.getGame((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(games, gamesService.countGames());
    }

    @TokenRequired
    @Log
    @PostMapping("add")
    public Map<String, Object> insertGames(@RequestBody GamesBean data) {
        data.setCreateTime(new Timestamp(new Date().getTime()));
        return CommonApi.success("successCount", gamesService.insertGame(data));

    }

    @TokenRequired
    @Log
    @PostMapping("update")
    public Map<String, Object> updateGames(@RequestBody GamesBean data) {

        Map<String, Object> map = new HashMap<>();
        map.put("successCount", gamesService.updateGame(data));
        return CommonApi.success(map, 1);
    }


    @TokenRequired
    @Log
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> data) {
        return CommonApi.success("successCount", gamesService.delGame((int) data.get("id")));
    }
}
