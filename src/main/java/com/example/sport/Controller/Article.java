package com.example.sport.Controller;
import com.example.sport.Bean.ArticleBean;
import com.example.sport.Bean.CommentBean;
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

    /**
    * @Description: 分页获取文章
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @GetMapping("/")
    Map<String, Object> articleList(@RequestParam Map<String, Object> params) {
        Map<String, Object> data = ParamsFormater.pageParams(params);
        // 分页查询
        return CommonApi.success(articleService.getArticle((int)data.get("page"), (int)data.get("pageSize")), articleService.countArticle());
    }

    /**
    * @Description: 添加文章
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @PostMapping("add")
    Map<String, Object> addArticle(@RequestBody ArticleBean article) {
        article.setCreateTime(new Timestamp(new Date().getTime()));
        return CommonApi.success("successCount", articleService.addArticle(article));
    }

    /**
    * @Description: 删除文章
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @PostMapping("delete")
    Map<String, Object> deleteArticle(@RequestBody Map<String, Object> data) {
        return CommonApi.success(articleService.delArticle((int) data.get("id")) > 0? "删除成功": "查无此文章", 1);
    }

    /**
    * @Description: 更新文章
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @PostMapping("update")
    public Map<String, Object> updateArticle(@RequestBody ArticleBean data) {
        Map<String, Object> map = new HashMap<>();
        map.put("修改成功数量", articleService.updateArticle(data));
        return CommonApi.success(map, 1);
    }



    /**
    * @Description: 获取评论
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @GetMapping("/comment")
    Map<String, Object> commentList(@RequestParam Map<String, Object> params) {
        Map<String, Object> data = ParamsFormater.pageParams(params);
        // 分页查询
        int articleId = Integer.parseInt(params.get("aid").toString());
        List<CommentBean> articleList = articleService.getComment(articleId, (int)data.get("page"), (int)data.get("pageSize"));
        return CommonApi.success(articleList, articleList.size());
    }

    /**
    * @Description:  添加评论
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @PostMapping("/comment/add")
    Map<String, Object> addComment(@RequestBody CommentBean comment) {
        comment.setCreateTime(new Timestamp(new Date().getTime()));
        return CommonApi.success("successCount", articleService.addComment(comment));
    }

    /**
    * @Description: 删除评论
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-22
    */
    @PostMapping("/comment/delete")
    Map<String, Object> deleteComment(@RequestBody Map<String, Object> data) {
        return CommonApi.success(articleService.deleteComment((int) data.get("id")) > 0? "删除成功": "查无此评论", 1);
    }
}
