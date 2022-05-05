package com.example.sport.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

/**
 * @program: sport
 * @description: 项目管理
 * @author: LeftHand
 * @create: 2022-05-05 21:04
 **/
@TableName("item")
public class ItemBean {
    @TableId
    private int id;
    @TableField("item_name")
    private String itemName;
    @TableField("max_person")
    private int maxPerson;
    @TableField("type")
    private int type;

    public ItemBean() {
    }

    public ItemBean(int id, String itemName, int maxPerson, int type) {
        this.id = id;
        this.itemName = itemName;
        this.maxPerson = maxPerson;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
