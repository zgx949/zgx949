package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.UserBean;
import com.example.sport.Bean.MenusBean;
import com.example.sport.Controller.User;
import com.example.sport.Mapper.UserMapper;
import com.example.sport.Mapper.MenusMapper;
import com.example.sport.Service.UserService;
import com.example.sport.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sport
 * @description: 管理员服务层实现
 * @author: 左手
 * @create: 2022-01-18 10:40
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenusMapper menusMapper;

    /**
     * @Description: 通过ID查询用户
     * @Param: int id 用户ID
     * @return:
     * @Author: 左手
     * @Date: 2022-02-13
     */
    @Override
    public UserBean findUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Map<String, Object> loginUser(String username, String password) {
        // 构造user表查询条件
        QueryWrapper<UserBean> queryWrapperUser = new QueryWrapper<>();
        queryWrapperUser.eq("username", username);
        //查询
        UserBean user = userMapper.selectOne(queryWrapperUser);
        if (user.getPassword().equals(password)) {
            // 账号密码正确
            Map<String, Object> data = new HashMap<>();
            data.put("uid", user.getId());
            data.put("name", user.getRealName());
            data.put("collegeId", user.getcollegeId());

            String token = JwtUtil.sign(user.getUsername(), String.valueOf(user.getId()),user.getPassword());
            data.put("token", token);
            return data;
        } else {
            // 账号密码错误
            return null;
        }

    }


    @Override
    public boolean exitUser(String username) {
        // 构造user表查询条件
        QueryWrapper<UserBean> queryWrapperUser = new QueryWrapper<>();
        return userMapper.selectCount(queryWrapperUser.eq("username", username)) > 0;
    }

    @Override
    public int insertUser(UserBean user) {
        // 判断账号是否存在, 不存在就插入记录
        return exitUser(user.getUsername()) ? -1 : userMapper.insert(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(UserBean user) {
        return userMapper.updateById(user);
    }

    @Override
    public List<UserBean> getUser(int page, int pageSize) {
        return userMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    @Override
    public int countUser() {
        return userMapper.selectCount(null);
    }
}
