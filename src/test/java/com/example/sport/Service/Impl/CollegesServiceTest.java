package com.example.sport.Service.Impl;
import com.example.sport.Bean.CollegesBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;


/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 16:53
 */
@SpringBootTest
public class CollegesServiceTest {
    @Resource
    CollegesServiceImpl collegesService;

    @Test
    public void testInsertCollege() {
        CollegesBean college = new CollegesBean(1,"操场",30);
        System.out.println(collegesService.insertCollege(college));
    }

    @Test
    public void testDelCollege() {
        System.out.println(collegesService.delCollege(2));
    }

    @Test
    public void testUpdateField() {
        CollegesBean college = new CollegesBean(1,"体育馆",60);
        System.out.println(collegesService.updateField(college));
    }

    @Test
    public void testGetCollege() {
        System.out.println(collegesService.getCollege(1,10));
    }

    @Test
    public void testCountColleges() {
        System.out.println(collegesService.countColleges());
    }

    @Test
    public void testCollegesOptions() {
        System.out.println(collegesService.collegesOptions());
    }
}