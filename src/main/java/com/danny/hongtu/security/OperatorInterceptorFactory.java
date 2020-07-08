package com.danny.hongtu.security;

import com.danny.hongtu.bean.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.danny.hongtu.util.TokenUtil.hasOperation;

/**
 * @author xhz
 * @version 1.0
 * @date 2019/8/2 18:59
 */
@Configuration
public class OperatorInterceptorFactory {
    @Bean
    public FictionInterceptor getDeviceInterceptor() {
        return new FictionInterceptor();
    }
}

class FictionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        boolean has = hasOperation(request, Operation.deviceInfo);
        if (has) {
            throw new RuntimeException("没有相关查看权限！");
        }
        return has;
    }
}
