package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

public class MenusBean {
//    @Id
    private int id;
    private String  name;
    private int parentId;
    private int levelId;

    public MenusBean() {
    }

    public MenusBean(int id, String name, int parentId, int levelId) {
        this.id = id;
        this.name = name;
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
