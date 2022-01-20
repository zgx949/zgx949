package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("menus")
public class MenusBean {
//    @Id
    @TableId
    private int id;
    @TableField("name")
    private String  name;
    @TableField("icon")
    private String  icon;
    @TableField("path")
    private String  path;
    @TableField("parent_id")
    private int parentId;
    @TableField("level_id")
    private int levelId;

    public MenusBean(int id, String name, String icon, String path, int parentId, int levelId) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.path = path;
        this.parentId = parentId;
        this.levelId = levelId;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
