package com.example.sport.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: sport
 * @description:
 * @author: 左手
 * @create: 2022-01-19 15:15
 **/
public class ParamsFormat {
    public static Map<String, Object> pageParams(Map<String, Object> data) {
        int page;
        int pageSize;
        try {
            page = Integer.parseInt(data.get("page").toString());
        } catch (Exception e) {
            page = 1;
        }
        try {
            pageSize = Integer.parseInt(data.get("pagesize").toString());
        } catch (Exception e) {
            pageSize = 10;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("pageSize", pageSize);
        return result;
    }
}
