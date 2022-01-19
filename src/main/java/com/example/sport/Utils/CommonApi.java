package com.example.sport.Utils;

import com.example.sport.Bean.AdminBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommonApi {
    /**
    * @Description: 公共接口
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
     public static Map<String, Object> common(Object data, String msg, int code, int count) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", msg);
        result.put("code", code);
        result.put("data", data);
        result.put("count", count);
        return result;

    }

    /**
    * @Description: 成功接口
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    public static Map<String, Object> success(List<Object> data) {
        return common(data, "操作成功", 1, 1);
    }

    public static Map<String, Object> success(String key, int value) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, value);
        return common(data, "操作成功", 1, 1);
    }

    public static Map<String, Object> success(Object data, int count) {
//        List<Object> result = new ArrayList<>();
//        result.add(data);
        return common(data, "操作成功", 0, count);
    }

    /**
    * @Description: 失败接口
    * @Param:
    * @return:
    * @Author: 左手
    * @Date: 2022-01-18
    */
    public static Map<String, Object> error(Object data) {
        return common(data, "非法操作", 0, 1);
    }

    public static Map<String, Object> error(Object data, int count) {
        List<Object> result = new ArrayList<>();
        result.add(data);
        return common(result, "非法操作", -1, count);
    }


}
