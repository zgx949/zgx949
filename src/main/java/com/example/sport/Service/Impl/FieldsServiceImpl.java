package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.FieldsBean;
import com.example.sport.Mapper.FieldsMapper;
import com.example.sport.Service.FieldsService;
import com.example.sport.Utils.BeanToTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sport
 * @description:
 * @author: 左手
 * @create: 2022-01-22 17:54
 **/
@Service
public class FieldsServiceImpl implements FieldsService {
    @Autowired
    FieldsMapper fieldsMapper;

    /**
    * @Description: 添加场地
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int insertField(FieldsBean field) {
        return fieldsMapper.insert(field);
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
        Map<String, Object> mp = new HashMap<>();
        QueryWrapper<FieldsBean> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id).or().eq("parent_id", id);
        return fieldsMapper.delete(queryWrapper);
    }

    /**
    * @Description: 更新场地
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int updateField(FieldsBean field) {
        return fieldsMapper.updateById(field);
    }

    /**
    * @Description: 获取场地
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public List<FieldsBean> getField(int parentId, int page, int pageSize) {
        QueryWrapper<FieldsBean> queryWrapper = new QueryWrapper();

        if (parentId == -1) {
            // 获取所有场地信息，并通过parent_id升序排序
            queryWrapper.select().orderByAsc("parent_id");

        } else {
            // 根据parent_id来进行筛选
            queryWrapper.eq("parent_id", parentId);

        }
        return fieldsMapper.selectPage(new Page<>(page, pageSize), queryWrapper).getRecords();
    }

    /**
    * @Description: 所有场地数量
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int countFields() {
        return fieldsMapper.selectCount(null);
    }

    /**
     * @Description: 获取场地书结构
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-02-11
     */
    @Override
    public List<Map<String, Object>> fieldTree() {
        List<Map<String, Object>> res = new ArrayList<>();
        for (FieldsBean item : fieldsMapper.selectList(null)) {
            res.add(item.toMap());
        }
        return BeanToTree.formatByParent(res);
    }
}
