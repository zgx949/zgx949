package com.example.sport.Service;

import com.example.sport.Bean.GamesBean;

import java.util.List;

public interface GamesService {
    /**
     * @Description: 增加
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int insertGame(GamesBean game);


    /**
     * @Description: 删除
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int delGame(int id);

    /**
     * @Description: 修改
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int updateGame(GamesBean game);

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    List<GamesBean> getGame(int page, int pageSize);

    int countGames();
}
