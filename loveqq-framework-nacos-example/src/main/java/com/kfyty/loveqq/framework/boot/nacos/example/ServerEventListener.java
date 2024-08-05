package com.kfyty.loveqq.framework.boot.nacos.example;

import com.kfyty.loveqq.framework.cloud.bootstrap.event.ServerEvent;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Component;
import com.kfyty.loveqq.framework.core.event.ApplicationListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@Component
public class ServerEventListener implements ApplicationListener<ServerEvent> {

    @Override
    public void onApplicationEvent(ServerEvent event) {
        log.info("on server event: {}", event);
    }
}
