package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.MenusBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Controller.Admin;
import com.example.sport.Mapper.AdminMapper;
import com.example.sport.Mapper.MenusMapper;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
            // 这里可以试试线程安全的 ConcurrentHashMap<>(), 或者用putIfAbsent()方法，保持一致性
            Map<String, Object> data = new HashMap<>();
            data.put("uid", admin.getId());
            data.put("name", admin.getName());
            data.put("collegeId", admin.getCollegeId());
            data.put("menus", getMenu(admin.getLevel()));
            String token = JwtUtil.sign(admin.getUsername(), String.valueOf(admin.getId()), admin.getPassword());
            data.put("token", token);

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
                // 同理，这里可以试试线程安全的 ConcurrentHashMap<>(), 或者用putIfAbsent()方法，保持一致性
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("menuid", menu.getId());
                tempMap.put("menuname", menu.getName());
                tempMap.put("icon", menu.getIcon());
                tempMap.put("url", menu.getPath());
                tempMap.put("menus", new ArrayList<>());
                menuList.add(tempMap);
            } else {
                // 如果是子菜单
                for (int i = 0; i < menuList.size(); i++) {
                    Map tempMap = (Map)menuList.get(i);
                    int parentId = (int) tempMap.get("menuid");

                    if (menu.getParentId() == parentId) {
                        // 最终要加入的子菜单
                        Map<String, Object> res = new HashMap<>();
                        res.put("menuid", menu.getId());
                        res.put("menuname", menu.getName());
                        res.put("icon", menu.getIcon());
                        res.put("url", menu.getPath());
                        res.put("menus", new ArrayList<>());
                        ((List)(((Map)menuList.get(i)).get("menus"))).add(res);
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
        return adminMapper.deleteById(id);
    }

    @Override
    public int updateAdmin(AdminBean admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public List<AdminBean> getAdmin(int page, int pageSize) {
        List<AdminBean> result = adminMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
        return result;
    }

    @Override
    public int countAdmin() {
        return adminMapper.selectCount(null);
    }

    @Override
    public List<menuOptionsBean> adminOptions() {
        List <AdminBean> admins = adminMapper.selectList(null);
        List<menuOptionsBean> menuOptionsBeanList = new ArrayList<>();
        for (AdminBean admin: admins) {
            menuOptionsBeanList.add(new menuOptionsBean(admin.getName(), admin.getId()));
        }
        return menuOptionsBeanList;
    }

    /**
     * @param id
     * @Description: 根据ID查询管理员
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-02-13
     */
    @Override
    public AdminBean findAdminById(int id) {
        return adminMapper.selectById(id);
    }
}
