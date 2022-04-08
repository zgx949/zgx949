package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.NumsBean;
import com.example.sport.Mapper.NumsMapper;
import com.example.sport.Service.NumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sport
 * @description:
 * @author: LeftHand
 * @create: 2022-02-10 17:54
 **/
@Service
public class NumsServiceImpl implements NumsService {
    @Autowired
    NumsMapper numsMapper;

    /**
    * @Description: 添加号码
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int insertNum(NumsBean Num) {
        return numsMapper.insert(Num);
    }

    /**
    * @Description: 删除号码
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int delNum(int id) {
        return numsMapper.deleteById(id);
    }

    /**
    * @Description: 更新号码
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int updateNum(NumsBean Num) {
        return numsMapper.updateById(Num);
    }

    /**
    * @Description: 获取号码
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public List<NumsBean> getNum(int page, int pageSize) {
        return numsMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    /**
    * @Description: 所有号码数量
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int countNums() {
        return numsMapper.selectCount(null);
    }
}
