package com.example.sport.Bean;

//import org.springframework.data.annotation.Id;

public class CollegesBean {
//    @Id
    private int id;
    private String name;
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
