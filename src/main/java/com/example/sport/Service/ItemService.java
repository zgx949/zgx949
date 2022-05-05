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
    int insertField(ItemBean item);


    /**
    * @Description: 删除
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int delField(int id);

    /**
    * @Description: 修改
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int updateField(ItemBean item);

    /**
    * @Description: 查询
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    List<ItemBean> getField(int parentId, int page, int pageSize);

    /**
    * @Description: 查询总数据量
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-11
    */
    int countItem();

}
