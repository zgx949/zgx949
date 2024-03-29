package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.MenusBean;
import com.example.sport.Bean.menuOptionsBean;
import com.example.sport.Mapper.AdminMapper;
import com.example.sport.Mapper.MenusMapper;
import com.example.sport.Service.AdminService;
import com.example.sport.Utils.JwtUtil;
import com.example.sport.Utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sport
 * @description: 管理员服务层实现
 * @author: LeftHand
 * @create: 2022-01-18 10:40
 **/

@Service
public class AdminServiceImpl implements AdminService {
    private final String salt = "z%^&!g@#*(x&9!@#&4^%$(!*@9&$";

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

        // 密码md5加盐校验
        if (admin.getPassword().equals(Md5Utils.encrypt3ToMD5(salt + password))) {
            // 账号密码正确
            // TODO:这里可以试试线程安全的 ConcurrentHashMap<>(), 或者用putIfAbsent()方法，保持一致性
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
            /*
                1.如果是顶级菜单
                2.同理，这里可以试试线程安全的 ConcurrentHashMap<>(), 或者用putIfAbsent()方法，保持一致性
            * */
            if (menu.getParentId() == menu.getId()) {
                // 如果是顶级菜单
                // 同理，这里可以试试线程安全的 ConcurrentHashMap<>(), 或者用putIfAbsent()方法，保持一致性
                // TODO: 修改为线程安全方法
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
    public boolean existsAdmin(String username) {
        // 构造admin表查询条件
        QueryWrapper<AdminBean> queryWrapperAdmin = new QueryWrapper<>();
        return adminMapper.selectCount(queryWrapperAdmin.eq("username", username)) > 0;
    }

    @Override
    public int insertAdmin(AdminBean admin) {
        // 密码先加盐处理
        admin.setPassword(Md5Utils.encrypt3ToMD5(salt + admin.getPassword()));
        // 判断账号是否存在, 不存在就插入记录
        return existsAdmin(admin.getUsername()) ? -1 : adminMapper.insert(admin);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public int updateAdmin(AdminBean admin) {
        // 密码先加盐处理
        admin.setPassword(Md5Utils.encrypt3ToMD5(salt + admin.getPassword()));
        return adminMapper.updateById(admin);
    }

    @Override
    public List<AdminBean> getAdmin(int page, int pageSize) {
        return adminMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
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
     * @Description: 根据ID查询管理员
     * @Param:
     * @return:
     * @Author: LeftHand
     * @Date: 2022-02-13
     */
    @Override
    public AdminBean findAdminById(int id) {
        return adminMapper.selectById(id);
    }
}
