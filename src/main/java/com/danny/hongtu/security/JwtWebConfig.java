package com.danny.hongtu.security;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author xhz
 * @version 1.0
 * @date 2019/6/28 17:20
 */
@SpringBootConfiguration
public class JwtWebConfig extends WebMvcConfigurationSupport {
    @Resource
    private TokenInterceptor tokenInterceptor;
    @Resource
    private FictionInterceptor fictionInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 登录和注销默认不拦截
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/logout", "/jitGWAuth", "/jitGWRandom", "/jitDownloadVCTK");
        // 设备信息查询
        registry.addInterceptor(fictionInterceptor)
                .addPathPatterns("/fiction/**")
                .excludePathPatterns();
    }
}
