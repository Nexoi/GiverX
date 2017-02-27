package com.seeu.userOAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by neo on 17/01/2017.
 */
@Configuration
//@EnableWebMvc ??????????? mgj
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public OAuthHandleInterceptor OAuthHandleInterceptor() {
        return new OAuthHandleInterceptor();
    }

    @Bean
    public FileDownloadInterceptor fileDownloadInterceptor() {
        return new FileDownloadInterceptor();
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(OAuthHandleInterceptor())
                //添加需要验证登录用户操作权限的请求
//                .excludePathPatterns("/user/login","user/register","user/register/*")
                .addPathPatterns("/user/**","/task/**")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/user/login","/user/register","/user/register/*");
        registry.addInterceptor(fileDownloadInterceptor())
                .addPathPatterns("/fsysdn/**");
//                .excludePathPatterns("");
    }
}
