package com.example.sport.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

//import org.springframework.data.annotation.Id;
@TableName("registrations")
public class RegistrationsBean {
    @TableId
    private int id;
    @TableField("game_id")
    private int gameId;
    @TableField("user_id")
    private int userId;
    @TableField("status")
    private int status;
    @TableField("reviewer_id")
    private int reviewerId;
    @TableField("create_time")
    @CreatedDate
    private Timestamp createTime;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public RegistrationsBean() {
    }

    public RegistrationsBean(int id, int gameId, int userId, int status, int reviewerId) {
        this.id = id;
        this.gameId = gameId;
        this.userId = userId;
        this.status = status;
        this.reviewerId = reviewerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }
}
