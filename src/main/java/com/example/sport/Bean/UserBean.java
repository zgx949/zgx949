package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public class UserBean {
//    @Id
    private int id;
    private String username;
    private String password;
    private String realName;
    private int gender;
    private int collegeId;
    private Timestamp createTime;
    private int athletesId;

    public UserBean() {
    }

    public UserBean(int id, String username, String password, String realName, int gender, int collegeId, Timestamp createTime, int athletesId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.gender = gender;
        this.collegeId = collegeId;
        this.createTime = createTime;
        this.athletesId = athletesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getcollegeId() {
        return collegeId;
    }

    public void setcollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getAthletesId() {
        return athletesId;
    }

    public void setAthletesId(int athletesId) {
        this.athletesId = athletesId;
    }
}
