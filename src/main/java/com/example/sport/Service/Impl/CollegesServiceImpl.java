package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.CollegesBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Mapper.CollegesMapper;
import com.example.sport.Service.CollegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sport
 * @description:
 * @author: LeftHand
 * @create: 2022-01-22 17:54
 **/
@Service
public class CollegesServiceImpl implements CollegesService {
    @Autowired
    CollegesMapper collegesMapper;

    /**
     * @Description: 添加场地
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-23
     */
    @Override
    public int insertCollege(CollegesBean college) {
        return collegesMapper.insert(college);
    }

    /**
     * @Description: 删除场地
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-23
     */
    @Override
    public int delCollege(int id) {
        return collegesMapper.deleteById(id);
    }

    /**
     * @Description: 更新场地
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-23
     */
    @Override
    public int updateField(CollegesBean field) {
        return collegesMapper.updateById(field);
    }

    /**
     * @Description: 获取场地
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-23
     */
    @Override
    public List<CollegesBean> getCollege(int page, int pageSize) {
        return collegesMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    /**
     * @Description: 所有场地数量
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-01-23
     */
    @Override
    public int countColleges() {
        return collegesMapper.selectCount(null);
    }

    @Override
    public List<menuOptionsBean> collegesOptions() {
        List <CollegesBean> colleges = collegesMapper.selectList(null);
        List<menuOptionsBean> menuOptionsBeanList = new ArrayList<>();
        for (CollegesBean college: colleges) {
            menuOptionsBeanList.add(new menuOptionsBean(college.getName(), college.getId()));
        }
        return menuOptionsBeanList;
    }
}
