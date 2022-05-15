package com.example.sport.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

/**
 * @program: sport
 * @isDescription: 项目管理
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
    @TableField("unit")
    private String unit;
    @TableField("is_desc")
    private int isDesc;

    public ItemBean() {
    }

    public ItemBean(int id, String itemName, int maxPerson, int type, String unit, int isDesc) {
        this.id = id;
        this.itemName = itemName;
        this.maxPerson = maxPerson;
        this.type = type;
        this.unit = unit;
        this.isDesc = isDesc;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDesc() {
        return isDesc;
    }

    public void setDesc(int isDesc) {
        this.isDesc = isDesc;
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
