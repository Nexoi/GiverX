package com.seeu.userOAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Created by neo on 17/01/2017.
 */
@Configuration
@EnableWebMvc
public class OAuthInterceptor extends WebMvcConfigurerAdapter {


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OAuthHandleInterceptor())
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/user/login");
    }
}
