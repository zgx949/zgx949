package com.example.sport.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.sport.Bean.AdminBean;
import com.example.sport.Bean.UserBean;
import com.example.sport.Service.AdminService;
import com.example.sport.Service.UserService;
import com.example.sport.Utils.CommonApi;
import com.example.sport.Utils.JwtUtil;
import com.example.sport.Annotation.TokenRequired;
import com.example.sport.Annotation.UserTokenRequired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * @program: sport
 * @description: token验证拦截器
 * @author: LeftHand
 * @create: 2022-02-13 14:01
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    /**
     * Swagger2 缺个白名单~~~~~校验方法
     */



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

                falseResult(httpServletResponse);
//                throw new RuntimeException("无token，请重新登录");
                return false;
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
                    falseResult(httpServletResponse);
//                    throw new RuntimeException("用户不存在，请重新登录");
                    return false;
                }
                // 验证 token
                try {
                    if (!JwtUtil.verity(token, person.getPassword())) {
                        falseResult(httpServletResponse);
                        return false;
//                        throw new RuntimeException("无效的令牌");
                    }
                } catch (JWTVerificationException e) {
                    falseResult(httpServletResponse);
//                    throw new RuntimeException("401");
                    return false;
                }
                return true;
            } else if (type == 2) {
                UserBean person = userService.findUserById(Integer.parseInt(id));
                if (person == null) {
                    falseResult(httpServletResponse);
                    return false;
//                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                try {
                    if (!JwtUtil.verity(token, person.getPassword())) {
                        falseResult(httpServletResponse);
                        return false;
//                        throw new RuntimeException("无效的令牌");
                    }
                } catch (JWTVerificationException e) {
                    falseResult(httpServletResponse);
                    return false;
//                    throw new RuntimeException("401");
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

    public void falseResult(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Map<String, Object> resultBody = CommonApi.error("msg", "无效token");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().println(objectMapper.writeValueAsString(resultBody));
    }

}

