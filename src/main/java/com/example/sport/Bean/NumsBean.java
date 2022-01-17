package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

public class NumsBean {
//    @Id
    private int id;
    private int idNum;
    private int collegeId;

    public NumsBean() {
    }

    public NumsBean(int id, int idNum, int collegeId) {
        this.id = id;
        this.idNum = idNum;
        this.collegeId = collegeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getcollegeId() {
        return collegeId;
    }

    public void setcollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
