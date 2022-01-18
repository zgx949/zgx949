package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;
@TableName("games")
public class GamesBean {
//    @Id
    private int id;
    private String gameName;
    private int nextGame;
    private int gender;
    private int fieldId;
    private int maxPerson;
    private int status;
    private Timestamp startTime;
    private Timestamp endTime;
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
