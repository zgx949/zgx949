package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.FieldsBean;
import com.example.sport.Mapper.FieldsMapper;
import com.example.sport.Service.FieldsService;
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
        return fieldsMapper.deleteById(id);
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
    public List<FieldsBean> getField(int page, int pageSize) {
        return fieldsMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
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
}
