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
    * @Description: 添加项目
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int insertItem(ItemBean item) {
        return itemMapper.insert(item);
    }

    /**
    * @Description: 删除项目
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int delItem(int id) {
        Map<String, Object> mp = new HashMap<>();
        QueryWrapper<ItemBean> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id).or().eq("parent_id", id);
        return itemMapper.delete(queryWrapper);
    }

    /**
    * @Description: 更新项目
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int updateItem(ItemBean item) {
        return itemMapper.updateById(item);
    }

    /**
    * @Description: 获取项目
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public List<ItemBean> getItem(int page, int pageSize) {
        QueryWrapper<ItemBean> queryWrapper = new QueryWrapper();

        return itemMapper.selectPage(new Page<>(page, pageSize), queryWrapper).getRecords();
    }

    /**
    * @Description: 所有项目数量
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
