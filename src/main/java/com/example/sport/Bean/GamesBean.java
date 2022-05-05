package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
@TableName("games")
public class GamesBean {
    @TableId
    private int id;
    @TableField("game_name")
    @TableId
    private int itemId;
    @TableField("item_id")
    private String gameName;
    @TableField("next_game")
    private int nextGame;
    @TableField("gender")
    private int gender;
    @TableField("field_id")
    private int fieldId;
    @TableField("max_person")
    private int maxPerson;
    @TableField("status")
    private int status;
    @TableField("start_time")
    @CreatedDate
    private Timestamp startTime;
    @TableField("end_time")
    @LastModifiedDate
    private Timestamp endTime;
    @TableField("create_time")
    @CreatedDate
    private Timestamp createTime;

    public GamesBean() {
    }

    public GamesBean(int id, String gameName, int nextGame, int gender, int fieldId, int maxPerson, int status, Timestamp startTime, Timestamp endTime, Timestamp createTime) {
        this.id = id;
        this.gameName = gameName;
        this.nextGame = nextGame;
        this.gender = gender;
        this.fieldId = fieldId;
        this.maxPerson = maxPerson;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNextGame() {
        return nextGame;
    }

    public void setNextGame(int nextGame) {
        this.nextGame = nextGame;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
