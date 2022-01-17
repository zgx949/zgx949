package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public class ArticleBean {
//    @Id
    private int id;
    private String text;
    private int adminId;
    private Timestamp createTime;

    public ArticleBean() {
    }

    public ArticleBean(int id, String text, int adminId, Timestamp createTime) {
        this.id = id;
        this.text = text;
        this.adminId = adminId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
