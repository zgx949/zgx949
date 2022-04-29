package com.example.sport.Service.Impl;

import com.example.sport.Bean.ArticleBean;
import com.example.sport.Bean.CommentBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 12:10
 */
@SpringBootTest
public class ArticleServiceTest {
    @Resource
    ArticleServiceImpl articleService;

    @Test
    public void testAddArticle() {
        Timestamp timestamp = Timestamp.valueOf("2022-04-15 10:30:11");
        ArticleBean article = new ArticleBean(1,"测试标题","测试文本",9,timestamp);
        System.out.println(articleService.addArticle(article));
    }
    @Test
    public void testDelArticle() {
        System.out.println(articleService.delArticle(2));
    }

    @Test
    public void testUpdateArticle() {
        Timestamp timestamp = Timestamp.valueOf("2022-04-15 11:30:11");
        ArticleBean article = new ArticleBean(1,"修改测试标题","测试文本11",9,timestamp);
        System.out.println(articleService.updateArticle(article));
    }

    @Test
    public void testGetArticle() {
        System.out.println(articleService.getArticle(1,10));
    }

    @Test
    public void testGetArticleById() {
        System.out.println(articleService.getArticleById(1));
    }

    @Test
    public void testCountArticle() {
        System.out.println(articleService.countArticle());
    }

    @Test
    public void testAddComment() {
        CommentBean comment = new CommentBean(11,1,"这是个测试标题");
        System.out.println(articleService.addComment(comment));
    }

    @Test
    public void testDeleteComment() {
        System.out.println(articleService.deleteComment(1));
    }

    @Test
    public void testGetComment() {
        System.out.println(articleService.getComment(1,1,10));
    }
}