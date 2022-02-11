package com.example.sport.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.data.annotation.Id;
@TableName("fields")
public class FieldsBean {
    @TableId
    private int id;
    @TableField("name")
    private String name;
    @TableField("max_person")
    private int maxPerson;
    @TableField("parent_id")
    private int parentId;

    public FieldsBean() {
    }

    public FieldsBean(int id, String name, int maxPerson, int parentId) {
        this.id = id;
        this.name = name;
        this.maxPerson = maxPerson;
        this.parentId = parentId;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", this.id);
        data.put("name", this.name);
        data.put("maxPerson", this.maxPerson);
        data.put("parentId", this.parentId);
        return data;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
