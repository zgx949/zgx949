package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.MenusBean;
import com.example.sport.Mapper.AdminMapper;
import com.example.sport.Mapper.MenusMapper;
import com.example.sport.Service.AdminService;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private MenusMapper menusMapper;

    @Override
    public Map<String, Object> loginAdmin(String username, String password) {
        // 构造admin表查询条件
        QueryWrapper<AdminBean> queryWrapperAdmin = new QueryWrapper<>();
        queryWrapperAdmin.eq("username", username);
        //查询
        AdminBean admin = adminMapper.selectOne(queryWrapperAdmin);
        if (admin.getPassword().equals(password)) {
            // 账号密码正确
            Map data = new HashMap<>();
            data.put("uid", admin.getId());
            data.put("menus", getMenu(admin.getLevel()));

            return data;
        } else {
            // 账号密码错误
            return null;
        }

    }

    @Override
    public List<Object> getMenu(int levelId) {
        // 构建查询level_id
        QueryWrapper<MenusBean> queryWrapperMenu = new QueryWrapper<>();
        queryWrapperMenu.ge("level_id", levelId);

        // 生成菜单树
        List<Object> menuList = new ArrayList<>();

        // 查询
        List<MenusBean> menus = menusMapper.selectList(queryWrapperMenu);
        for (MenusBean menu : menus) {
            if (menu.getParentId() == menu.getId()) {
                // 如果是顶级菜单
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("id", menu.getId());
                tempMap.put("name", menu.getName());
                tempMap.put("path", menu.getPath());
                tempMap.put("children", new ArrayList<>());
                menuList.add(tempMap);
            } else {
                // 如果是子菜单
                for (int i = 0; i < menuList.size(); i++) {
                    Map tempMap = (Map)menuList.get(i);
                    int parentId = (int) tempMap.get("id");

                    if (menu.getParentId() == parentId) {
                        // 最终要加入的子菜单
                        Map<String, Object> res = new HashMap<>();
                        res.put("id", menu.getId());
                        res.put("name", menu.getName());
                        res.put("path", menu.getPath());
                        res.put("children", new ArrayList<>());
                        ((List)(((Map)menuList.get(i)).get("children"))).add(res);
                        break;
                    }

                }
            }
        }
        return menuList;
    }

    @Override
    public boolean exitAdmin(String username) {
        // 构造admin表查询条件
        QueryWrapper<AdminBean> queryWrapperAdmin = new QueryWrapper<>();
        return adminMapper.selectCount(queryWrapperAdmin.eq("username", username)) > 0;
    }

    @Override
    public int insertAdmin(AdminBean admin) {
        // 判断账号是否存在, 不存在就插入记录
        return exitAdmin(admin.getUsername()) ? -1 : adminMapper.insert(admin);
    }

    @Override
    public int deleteAdmin(int id) {
        return 0;
    }

    @Override
    public int updateAdmin(Map<String, Object> admin) {
        return 0;
    }

    @Override
    public List<AdminBean> getAdmin(int page, int pageSize) {
        List<AdminBean> result = adminMapper.selectList(null);
        return result;
    }
}
