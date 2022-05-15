package com.example.sport.Utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @program: sport
 * @description: Md5加密
 * @author: LeftHand
 * @create: 2022-05-15 11:11
 **/
public class Md5Utils {
    /**
     * MD5加密之方法三
     * @explain springboot自带MD5加密
     * @param str
     *            待加密字符串
     * @return 16进制加密字符串
     */

    public static String encrypt3ToMD5(String str) {
        String md5 = "  ";
        try {
            md5 = DigestUtils.md5DigestAsHex(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5;
    }

}
