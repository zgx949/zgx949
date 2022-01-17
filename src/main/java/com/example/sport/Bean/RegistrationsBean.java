package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

public class RegistrationsBean {
//    @Id
    private int id;
    private int gameId;
    private int userId;
    private int status;
    private int reviewerId;

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
