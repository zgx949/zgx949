package com.example.sport.Controller;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.ArticleBean;
import com.example.sport.Service.ArticleService;

import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class Article {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    Map<String, Object> articleList(@RequestParam Map<String, Object> params) {
        Map<String, Object> data = ParamsFormater.pageParams(params);
        // 分页查询
        List<ArticleBean> articleList = articleService.getArticle((int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(articleList, articleList.size());
    }

    @PostMapping("add")
    Map<String, Object> addArticle(@RequestBody ArticleBean article) {
        article.setCreateTime(new Timestamp(new Date().getTime()));
        return CommonApi.success("successCount", articleService.addArticle(article));
    }

    @PostMapping("delete")
    Map<String, Object> deleteArticle(@RequestBody Map<String, Object> data) {
        return CommonApi.success(articleService.delArticle((int) data.get("id")) > 0? "删除成功": "查无此文章", 1);
    }

    @PostMapping("update")
    public Map<String, Object> updateAdmin(@RequestBody ArticleBean data) {
        Map<String, Object> map = new HashMap<>();
        map.put("修改成功数量", articleService.updateArticle(data));
        return CommonApi.success(map, 1);
    }






}
