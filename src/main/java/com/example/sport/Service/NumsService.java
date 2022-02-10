package com.example.sport.Service;

import com.example.sport.Bean.NumsBean;

import java.util.List;

public interface NumsService {
    /**
     * @Description: 增加
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-02-10
     */
    int insertNum(NumsBean num);


    /**
     * @Description: 删除
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-02-10
     */
    int delNum(int id);

    /**
     * @Description: 修改
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-02-10
     */
    int updateNum(NumsBean num);

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: 左手
     * @Date: 2022-02-10
     */
    List<NumsBean> getNum(int page, int pageSize);

    int countNums();
}
