package com.example.sport.Service.Impl;

import com.example.sport.Bean.NumsBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 18:43
 */
@SpringBootTest
public class NumsServiceTest {
    @Resource
    NumsServiceImpl numsService;

    @Test
    public void testInsertNum() {
        NumsBean num = new NumsBean(1,10001,1);
        System.out.println(numsService.insertNum(num));
    }

    @Test
    public void testDelNum() {
        System.out.println(numsService.delNum(1));
    }

    @Test
    public void testUpdateNum() {
        NumsBean num = new NumsBean(1,10002,1);
        System.out.println(numsService.updateNum(num));
    }

    @Test
    public void testGetNum() {
        System.out.println(numsService.getNum(1,10));
    }

    @Test
    public void testCountNums() {
        System.out.println(numsService.countNums());
    }
}