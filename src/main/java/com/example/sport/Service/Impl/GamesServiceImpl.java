package com.example.sport.Service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sport.Bean.GamesBean;
import com.example.sport.Mapper.GamesMapper;
import com.example.sport.Service.GamesService;
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
public class GamesServiceImpl implements GamesService {
    @Autowired
    GamesMapper gamesMapper;

    /**
    * @Description: 添加比赛
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int insertGame(GamesBean game) {
        return gamesMapper.insert(game);
    }

    /**
    * @Description: 删除比赛
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int delGame(int id) {
        return gamesMapper.deleteById(id);
    }

    /**
    * @Description: 更新比赛
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int updateGame(GamesBean game) {
        return gamesMapper.updateById(game);
    }

    /**
    * @Description: 获取比赛
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public List<GamesBean> getGame(int page, int pageSize) {
        return gamesMapper.selectPage(new Page<>(page, pageSize), null).getRecords();
    }

    /**
    * @Description: 所有比赛数量
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-23
    */
    @Override
    public int countGames() {
        return gamesMapper.selectCount(null);
    }
}
