package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@TableName("reports")
public class ReportsBean {
    @TableId
    private int id;
    @TableField("game_id")
    private int gameId;
    @TableField("user_id")
    private int userId;
    @TableField("create_time")
    @CreatedDate
    private Timestamp createTime;

    public ReportsBean() {
    }

    public ReportsBean(int id, int gameId, int userId, Timestamp createTime) {
        this.id = id;
        this.gameId = gameId;
        this.userId = userId;
        this.createTime = createTime;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
