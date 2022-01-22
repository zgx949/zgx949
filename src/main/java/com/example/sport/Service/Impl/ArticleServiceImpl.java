package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.ArticleBean;
import com.example.sport.Bean.CommentBean;
import com.example.sport.Mapper.ArticleMapper;
import com.example.sport.Mapper.CommentMapper;
import com.example.sport.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sport
 * @description: 文章的增、删、查
 * @author: 左手
 * @create: 2022-01-19 15:41
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CommentMapper commentMapper;

    /**
    * @Description: 增加文章
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public int addArticle(ArticleBean article) {
        return articleMapper.insert(article);
    }

    /**
    * @Description: 删除文章
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public int delArticle(int id) {
        return articleMapper.deleteById(id);
    }

    /**
    * @Description: 修改
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public int updateArticle(ArticleBean article) {
        articleMapper.updateById(article);
        return 0;
    }

    /**
    * @Description: 分页获取文章列表
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public List<ArticleBean> getArticle(int page, int pageSize) {
        return articleMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    /**
    * @Description: 根据ID查找文章具体内容
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public ArticleBean getArticleById(int id) {
        return articleMapper.selectById(id);
    }

    /**
    * @Description: 添加评论
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public int addComment(CommentBean comment) {
        return commentMapper.insert(comment);
    }

    /**
    * @Description: 删除评论
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public int deleteComment(int articleId) {
        return commentMapper.deleteById(articleId);
    }

    /**
    * @Description: 分页获取评论列表
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-19
    */
    @Override
    public List<CommentBean> getComment(int articleId, int page, int pageSize) {
        QueryWrapper<CommentBean> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", articleId);
        return commentMapper.selectPage(new Page<>(page, pageSize), wrapper).getRecords();
    }
}
