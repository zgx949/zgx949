package com.example.sport.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//import org.springframework.data.annotation.Id;
@TableName("colleges")
public class CollegesBean {
//    @Id
    @TableId
    private int id;
    @TableField("name")
    private String name;
    @TableField("max_person")
    private int maxPerson;

    public CollegesBean() {
    }

    public CollegesBean(int id, String name, int maxPerson) {
        this.id = id;
        this.name = name;
        this.maxPerson = maxPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }
}
