package com.kfyty.loveqq.framework.boot.web.example.config;

import com.kfyty.loveqq.framework.core.autoconfig.annotation.Component;
import com.kfyty.loveqq.framework.web.core.http.ServerRequest;
import com.kfyty.loveqq.framework.web.core.http.ServerResponse;
import com.kfyty.loveqq.framework.web.core.interceptor.ReactiveHandlerInterceptor;
import com.kfyty.loveqq.framework.web.core.mapping.MethodMapping;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 描述: 响应式拦截器
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@Component
public class LogHandlerInterceptor implements ReactiveHandlerInterceptor {

    @Override
    public Mono<Boolean> preHandleAsync(ServerRequest request, ServerResponse response, MethodMapping handler) {
        return Mono.fromRunnable(() -> log.info("preHandleAsync: {}", request.getRequestURI())).thenReturn(true);
    }

    @Override
    public Mono<Void> postHandleAsync(ServerRequest request, ServerResponse response, MethodMapping handler, Object retValue) {
        return Mono.fromRunnable(() -> log.info("postHandleAsync: {} {}", request.getRequestURI(), retValue));
    }

    @Override
    public Mono<Void> afterCompletionAsync(ServerRequest request, ServerResponse response, MethodMapping handler, Throwable ex) {
        return Mono.fromRunnable(() -> log.info("afterCompletionAsync: {}", request.getRequestURI(), ex));
    }
}
