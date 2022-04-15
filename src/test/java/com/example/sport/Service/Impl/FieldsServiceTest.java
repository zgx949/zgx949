package com.example.sport.Service.Impl;

import com.example.sport.Bean.FieldsBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 18:10
 */
@SpringBootTest
public class FieldsServiceTest {
    @Resource
    FieldsServiceImpl fieldsService;

    @Test
    public void testInsertField() {
        FieldsBean fields = new FieldsBean(1,"这是一个测试场地",30,9);
        System.out.println(fieldsService.insertField(fields));
    }

    @Test
    public void testDelField() {
        System.out.println(fieldsService.delField(1));
    }

    @Test
    public void testUpdateField() {
        FieldsBean fields = new FieldsBean(1,"更改名字之后的测试场地",40,9);
        System.out.println(fieldsService.updateField(fields));
    }

    @Test
    public void testGetField() {
        System.out.println(fieldsService.getField(9,1,10));
    }

    @Test
    public void testCountFields() {
        System.out.println(fieldsService.countFields());
    }

    @Test
    public void testFieldTree() {
        System.out.println(fieldsService.fieldTree());
    }
}