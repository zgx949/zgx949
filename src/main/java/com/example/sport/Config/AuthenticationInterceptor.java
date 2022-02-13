package com.example.sport.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.UserBean;
import com.example.sport.Service.AdminService;
import com.example.sport.Service.UserService;
import com.example.sport.Utils.JwtUtil;
import com.example.sport.annotation.TokenRequired;
import com.example.sport.annotation.UserTokenRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @program: sport
 * @description: token验证拦截器
 * @author: 左手
 * @create: 2022-02-13 14:01
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;



    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        int type = 0;   // 0为admin验证，1为user验证
        if (method.isAnnotationPresent(TokenRequired.class)) {
            // 管理员
            type = 1;
            TokenRequired LoginToken = method.getAnnotation(TokenRequired.class);
            if (!LoginToken.required()) {
                return false;
            }
        } else if (method.isAnnotationPresent(UserTokenRequired.class)) {
            // 用户
            type = 2;
            UserTokenRequired LoginToken = method.getAnnotation(UserTokenRequired.class);
            if (!LoginToken.required()) {
                return false;
            }
        }


        if (type != 0) {
            // 执行认证
            if (token == null) {
                throw new RuntimeException("无token，请重新登录");
            }
            // 获取 token 中的 admin或者user的id
            String id;
            try {
                id = JWT.decode(token).getClaim("id").asString();
            } catch (JWTDecodeException j) {
                throw new RuntimeException("401");
            }
            if (type == 1) {
                AdminBean person = adminService.findAdminById(Integer.parseInt(id));
                if (person == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                try {
                    if (!JwtUtil.verity(token, person.getPassword())) {
                        throw new RuntimeException("无效的令牌");
                    }
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            } else if(type == 2) {
                UserBean person = userService.findUserById(Integer.parseInt(id));
                if (person == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                try {
                    if (!JwtUtil.verity(token, person.getPassword())) {
                        throw new RuntimeException("无效的令牌");
                    }
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
