package com.example.sport.Controller;
import com.example.sport.Bean.ArticleBean;
import com.example.sport.Service.ArticleService;

import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.ParamsFormater;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return CommonApi.success("article_id", articleService.addArticle(article));
    }


}
