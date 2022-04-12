package com.example.sport.Service;

import com.example.sport.Bean.ArticleBean;
import com.example.sport.Bean.CommentBean;

import java.util.List;

public interface ArticleService {

    /**
     * @Description: 发布公告文章
     * @Param: atricle实体
     * @return: 添加的个数
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int addArticle(ArticleBean article);

    /**
     * @Description: 删除
     * @Param: id
     * @return: 删除的个数
     * @Author: LeftHand
     * @Date: 2022-01-18
     */
    int delArticle(int id);

    /**
    * @Description: 更新
    * @Param: 实体
    * @return: 更新个数
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int updateArticle(ArticleBean article);


    /**
    * @Description: 分页获取文章
    * @Param: 页码
    * @Param: 页面大小
    * @return: List实体
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    List<ArticleBean> getArticle(int page, int pageSize);


    /**
    * @Description: 通过id获取文章实体
    * @Param: id
    * @return: 文章实体
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    ArticleBean getArticleById(int id);


    /**
    * @Description: 新增文章评论
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int addComment(CommentBean comment);

    /**
    * @Description: 删除评论
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int deleteComment(int articleId);

    /**
    * @Description: 获取评论
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    List<CommentBean> getComment(int articleId, int page, int pageSize);

    int countArticle();
}
