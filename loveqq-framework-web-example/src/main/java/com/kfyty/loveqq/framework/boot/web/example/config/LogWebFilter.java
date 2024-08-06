package com.kfyty.loveqq.framework.boot.web.example.config;

import com.kfyty.loveqq.framework.core.autoconfig.annotation.Component;
import com.kfyty.loveqq.framework.web.core.http.ServerRequest;
import com.kfyty.loveqq.framework.web.core.http.ServerResponse;
import com.kfyty.loveqq.framework.web.mvc.netty.filter.Filter;
import com.kfyty.loveqq.framework.web.mvc.netty.filter.FilterChain;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@Component
public class LogWebFilter implements Filter {

    @Override
    public Mono<Void> doFilter(ServerRequest request, ServerResponse response, FilterChain chain) {
        return Mono.just(request).doOnNext(e -> log.info("URI: {}", e.getRequestURI())).then(chain.doFilter(request, response));
    }
}
