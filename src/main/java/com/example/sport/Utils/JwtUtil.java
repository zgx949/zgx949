package com.example.sport.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;
import java.util.HashMap;

/**
 * @program: sport
 * @description: JWT签名计算计算工具
 * @author: 左手
 * @create: 2022-02-13 13:50
 **/
public class JwtUtil {

    //过期时间86400分钟
    private static final long EXPIRE_TIME = 24*60*60*1000;

    //生成签名,86400分钟后过期
    public static String sign(String username,String id,String password){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //使用用户密码作为私钥进行加密
        Algorithm algorithm = Algorithm.HMAC256(password);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和adminID生成签名
        return JWT.create().withHeader(header).withClaim("id", id)
                .withClaim("username",username).withExpiresAt(date).sign(algorithm);
    }

    //校验token
    public static boolean verity(String token,String password){
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (IllegalArgumentException | JWTVerificationException e) {
            return false;
        }
    }
}
