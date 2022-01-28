package com.example.sport.Bean;

/**
 * @program: sport
 * @description: 后台选项表的实体对象
 * @author: 左手
 * @create: 2022-01-28 11:30
 **/
public class menuOptionsBean {
    private String label;
    private int value;

    public menuOptionsBean(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
