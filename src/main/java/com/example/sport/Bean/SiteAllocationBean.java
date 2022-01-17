package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

public class SiteAllocationBean {
//    @Id
    private int id;
    private int userId;
    private int gameId;
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
