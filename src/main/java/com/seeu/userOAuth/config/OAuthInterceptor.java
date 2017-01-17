package com.seeu.userOAuth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by neo on 17/01/2017.
 */
@Configuration
public class OAuthInterceptor extends WebMvcConfigurerAdapter {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OAuthHandleInterceptor())
                //添加需要验证登录用户操作权限的请求
//                .addPathPatterns("/testContrl/create*", "/testContrl/update*", "/testContrl/delete*")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/userCtrl/*");
    }
}
