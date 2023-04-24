package com.jxh.config;

import com.jxh.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author meizh
 * 登录拦截配置类
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    /**
     * 引入登录异常
     */
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                //黑名单
                .addPathPatterns("/**")
                //白名单
                .excludePathPatterns("/login")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/js/**");
    }
}
