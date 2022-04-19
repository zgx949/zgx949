package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@TableName("article")
public class ArticleBean {
//    @Id
    @TableId
    private int id;
    @TableField("title")
    private String title;
    @TableField("text")
    private String text;
    @TableField("admin_id")
    private int adminId;
    @TableField("create_time")
    @CreatedDate
    private Timestamp createTime;

    public ArticleBean() {
    }

    public ArticleBean(int id, String title, String text, int adminId, Timestamp createTime) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
