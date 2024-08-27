package com.example.sp61.config

import com.example.sp61.interceptor.TokenInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMVCConfig :WebMvcConfigurer {

    @Autowired
    lateinit var tokenInterceptor: TokenInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(tokenInterceptor)
            .addPathPatterns("/headline/**")//token拦截验证路径
//            .excludePathPatterns("/user/login","/user/register")
        super.addInterceptors(registry)
    }

}