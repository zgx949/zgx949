package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public class CommentBean {
//    @Id
    private int id;
    private int articleId;
    private int userId;
    private String text;
    private Timestamp createTime;

    public CommentBean() {
    }

    public CommentBean(int id, int articleId, int userId, String text, Timestamp createTime) {
        this.id = id;
        this.articleId = articleId;
        this.userId = userId;
        this.text = text;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
