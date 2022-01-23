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
    int insertField(GamesBean field);


    /**
     * @Description: 删除
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int delField(int id);

    /**
     * @Description: 修改
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    int updateField(GamesBean field);

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-01-18
     */
    List<GamesBean> getField(int page, int pageSize);

    int countGames();
}
