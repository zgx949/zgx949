package com.example.sport.Service;

import com.example.sport.Bean.ItemBean;

import java.util.List;
import java.util.Map;

public interface ItemService {
    /**
    * @Description: 增加
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int insertItem(ItemBean item);


    /**
    * @Description: 删除
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int delItem(int id);

    /**
    * @Description: 修改
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int updateItem(ItemBean item);

    /**
    * @Description: 查询
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    List<ItemBean> getItem(int page, int pageSize);

    /**
    * @Description: 查询总数据量
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-11
    */
    int countItem();

}
