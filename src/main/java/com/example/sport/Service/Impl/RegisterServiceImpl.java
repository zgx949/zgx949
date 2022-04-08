package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.RegistrationsBean;
import com.example.sport.Mapper.RegisterMapper;
import com.example.sport.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sport
 * @description:
 * @author: LeftHand
 * @create: 2022-01-24 17:54
 **/
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    /**
    * @Description: 添加报名表
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int insertGame(RegistrationsBean game) {
        return registerMapper.insert(game);
    }

    /**
    * @Description: 删除报名表
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int delGame(int id) {
        return registerMapper.deleteById(id);
    }

    /**
    * @Description: 更新报名表
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int updateGame(RegistrationsBean game) {
        return registerMapper.updateById(game);
    }

    /**
    * @Description: 获取报名表
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public List<RegistrationsBean> getGame(int page, int pageSize) {
        return registerMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    /**
    * @Description: 所有报名表数量
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-23
    */
    @Override
    public int countRegister() {
        return registerMapper.selectCount(null);
    }
}
