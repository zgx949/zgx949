package com.example.sport.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sport
 * @description: 将复合数据对象整理成树格式
 * @author: LeftHand
 * @create: 2022-02-11 15:26
 **/

public class BeanToTree {
    /**
    * @Description: 根据parentId来进行封装(数据必须先按照parentId大到小排序)
    * @Param: rawData: List 原始数据
    * @Param: offsetIndex: int 已经封装的数据位置
    * @return:
    * @Author: LeftHand
    * @Date: 2022-02-11
    */
    public static List<Map<String, Object>> formatByParent(List<Map<String, Object>> rawData, int offsetIndex) {
        List<Map<String, Object>> res = new ArrayList<>();
        int i = 0;
        for (Map<String, Object> item: rawData) {
            if (item.get("parentId").equals(0)) {
                // 顶级场地
                List<Map<String, Object>> children = findChild(rawData, i);
                item.put("children", children);
                res.add(item);
            }
            i ++;
        }
        return res;
    }

    public static List<Map<String, Object>> findChild(List<Map<String, Object>> rawData, int offsetIndex) {
        List<Map<String, Object>> res = new ArrayList<>();
        Integer id = Integer.parseInt(rawData.get(offsetIndex).get("id").toString());

        for (int i = offsetIndex; i < rawData.size(); i++) {
            if (rawData.get(i).get("parentId").equals(id)) {
                rawData.get(i).put("children", findChild(rawData, i));
                res.add(rawData.get(i));
            }
        }
        return res;
    }

    public static List<Map<String, Object>> formatByParent(List<Map<String, Object>> rawData) {
        return formatByParent(rawData, 0);
    }

}
