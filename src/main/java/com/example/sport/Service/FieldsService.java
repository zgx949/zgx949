package com.example.sport.Service;

import com.example.sport.Bean.FieldsBean;
import com.example.sport.Bean.menuOptionsBean;

import java.util.List;
import java.util.Map;

public interface FieldsService {
    /**
    * @Description: 增加
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    int insertField(FieldsBean field);


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
    int updateField(FieldsBean field);

    /**
    * @Description: 查询
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    List<FieldsBean> getField(int parentId, int page, int pageSize);

    /**
    * @Description: 查询总数据量
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-11
    */
    int countFields();

    /**
    * @Description: 获取场地书结构
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-11
    */
    List<Map<String, Object>> fieldTree();

    /**
    * @Description: 获取场地映射表
    * @Param:
    * @return:
    * @Author: leftHand
    * @Date: 2022-05-15
    */
    List<menuOptionsBean> fieldOptions();
}
