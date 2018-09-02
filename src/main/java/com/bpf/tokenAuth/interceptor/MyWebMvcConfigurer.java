package com.bpf.tokenAuth.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired 
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {       
        //这里res下存在的资源不拦截，但是随便输一个不存在的/res/asdasd，按理说应该也不会被拦截，只是报404，然而却被拦截了
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/res/**", "/page/**");
    }
    
}
