package com.example.sport.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonApi {
     public static Map<String, Object> common(List<Object> data, String msg, int code) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", msg);
        result.put("code", code);
        result.put("data", data);
        return result;

    }

    public static Map<String, Object> success(List<Object> data) {
        return common(data, "操作成功", 1);
    }

    public static Map<String, Object> success(Map<String, Object> data) {
        List<Object> result = new ArrayList<>();
        result.add(data);
        return common(result, "操作成功", 1);
    }

    public static Map<String, Object> error(List<Object> data) {
        return common(data, "非法操作", 0);
    }

    public static Map<String, Object> error(Map<String, Object> data) {
        List<Object> result = new ArrayList<>();
        result.add(data);
        return common(result, "非法操作", 0);
    }


}
