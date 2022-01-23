package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("site_allocation")
public class SiteAllocationBean {
    @TableId
    private int id;
    @TableField("user_id")
    private int userId;
    @TableField("game_id")
    private int gameId;
    @TableField("field_id")
    private int fieldId;

    public SiteAllocationBean() {
    }

    public SiteAllocationBean(int id, int userId, int gameId, int fieldId) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.fieldId = fieldId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }
}
