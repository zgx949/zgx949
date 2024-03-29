package com.example.sport.Utils;

import com.example.sport.Bean.AdminBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 公共接口
 * @Author: LeftHand
 * @Date: 2022-01-18
 */
public class CommonApi {
    //TODO: 重构公共接口API，把冗余的类型用泛型来替代


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
    * @Author: LeftHand
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
        return common(data, "操作成功", 1, count);
    }

    /**
    * @Description: 失败接口
    * @Param:
    * @return:
    * @Author: LeftHand
    * @Date: 2022-01-18
    */
    public static Map<String, Object> error(Object data) {
        String msg = "非法操作";
        if (((Map<String, Object>) data).containsKey("msg")) {
            msg = (String) ((Map<String, Object>) data).get("msg");
        }

//        return common(data, "非法操作", 0, 1);
        return common(data, msg, 0, 1);
    }

    public static Map<String, Object> error(Object data, int count) {
        List<Object> result = new ArrayList<>();
        result.add(data);
        return common(result, "非法操作", -1, count);
    }



    public static Map<String, Object> error(String key, int value) {
        Map<String, Object> data = new HashMap<>();
        if (key != null)
            data.put(key, value);
        return common(data, "非法操作", -1, 1);
    }
    public static Map<String, Object> error(String key, String value) {
        Map<String, Object> data = new HashMap<>();
        if (key != null)
            data.put(key, value);
        return common(data, "非法操作", -1, 1);
    }


}
