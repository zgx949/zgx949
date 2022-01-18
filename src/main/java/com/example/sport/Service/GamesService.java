package com.example.sport.Service;

import com.example.sport.Bean.GamesBean;
import com.example.sport.Bean.ReportsBean;
import com.example.sport.Bean.SiteAllocationBean;

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
    int delGame(GamesBean game);

    /**
    * @Description: 改
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int updateGame(GamesBean game);

    /**
    * @Description: 查
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    List<GamesBean> getGame(int page, int pageSize);

    /**
    * @Description: 针对个人分配场地
    * @Param:
    * @return:  成功分配个数
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int insertSiteAllocation(List<SiteAllocationBean> siteAllocations);

    /**
    * @Description: 增加成绩记录
    * @Param:
    * @return: 增加个数
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int insertReports(List<ReportsBean> reports);

    /**
    * @Description: 删除
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int delReport(int id);


    /**
    * @Description: 更新
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    int update(ReportsBean report);

    /**
    * @Description: 查询成绩
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    List<ReportsBean> getReports(int page, int pageSize);
}
