package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.CollegesBean;
import com.example.sport.Mapper.CollegesMapper;
import com.example.sport.Service.CollegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sport
 * @description:
 * @author: 左手
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
     * @Author: 左手
     * @Date: 2022-01-23
     */
    @Override
    public int insertField(CollegesBean field) {
        return collegesMapper.insert(field);
    }

    /**
     * @Description: 删除场地
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-23
     */
    @Override
    public int delField(int id) {
        return collegesMapper.deleteById(id);
    }

    /**
     * @Description: 更新场地
     * @Param:
     * @return:
     * @Author: 左手
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
     * @Author: 左手
     * @Date: 2022-01-23
     */
    @Override
    public List<CollegesBean> getField(int page, int pageSize) {
        return collegesMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    /**
     * @Description: 所有场地数量
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-23
     */
    @Override
    public int countColleges() {
        return collegesMapper.selectCount(null);
    }
}
