package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.ItemBean;
import com.example.sport.Mapper.ItemMapper;
import com.example.sport.Service.ItemService;
import com.example.sport.Utils.BeanToTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sport
 * @description:
 * @author: LeftHand
 * @create: 2022-01-22 17:54
 **/
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;

    /**
    * @Description: 添加场地
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int insertField(ItemBean item) {
        return itemMapper.insert(item);
    }

    /**
    * @Description: 删除场地
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int delField(int id) {
        Map<String, Object> mp = new HashMap<>();
        QueryWrapper<ItemBean> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id).or().eq("parent_id", id);
        return itemMapper.delete(queryWrapper);
    }

    /**
    * @Description: 更新场地
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int updateField(ItemBean item) {
        return itemMapper.updateById(item);
    }

    /**
    * @Description: 获取场地
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public List<ItemBean> getField(int parentId, int page, int pageSize) {
        QueryWrapper<ItemBean> queryWrapper = new QueryWrapper();

        if (parentId == -1) {
            // 获取所有场地信息，并通过parent_id升序排序
            queryWrapper.select().orderByAsc("parent_id");

        } else {
            // 根据parent_id来进行筛选
            queryWrapper.eq("parent_id", parentId);

        }
        return itemMapper.selectPage(new Page<>(page, pageSize), queryWrapper).getRecords();
    }

    /**
    * @Description: 所有场地数量
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int countItem() {
        return itemMapper.selectCount(null);
    }

}
