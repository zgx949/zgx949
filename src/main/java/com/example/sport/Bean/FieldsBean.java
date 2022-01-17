package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

public class FieldsBean {
//    @Id
    private int id;
    private String name;
    private int maxPerson;
    private int parentId;

    public FieldsBean() {
    }

    public FieldsBean(int id, String name, int maxPerson, int parentId) {
        this.id = id;
        this.name = name;
        this.maxPerson = maxPerson;
        this.parentId = parentId;
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
