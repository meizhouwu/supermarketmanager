package com.jxh.interceptor;

import com.jxh.constant.SystemConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 * @author meizh
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object o = session.getAttribute(SystemConstant.ADMIN_IN_SESSION);
        if (o==null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
