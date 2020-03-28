package com.kang.springboot.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author klr
 * @create 2020-03-27-16:07
 */

//登录拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //先取得用户信息  登录成功后应该有用户的session
        Object loginUser= request.getSession().getAttribute("loginUser");

        //如果用户session不存在
        if(loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
            //转发回去
            request.getRequestDispatcher("/index.html").forward(request,response);

            //没有登录，不放行
            return false;
        }
        else {

            return true;
        }
    }
}
