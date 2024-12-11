package com.kfyty.loveqq.framework.boot.web.example.mq;

import com.kfyty.loveqq.framework.boot.mq.rocket.autoconfig.annotation.RocketMQMessageListener;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述: mq 方法级示例
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@Component
@RocketMQMessageListener
public class NormalMessageConsumer {
    /**
     * 同一消费组的不同消费者会负载均衡消费
     */
    @RocketMQMessageListener(value = "loveqq-topic-normal", consumerGroup = "normal_group")
    public void onMessage(String message) {
        log.info("message1: {}", message);
    }

    @RocketMQMessageListener(value = "loveqq-topic-normal", consumerGroup = "normal_group")
    public void onMessage2(String message) {
        log.info("message2: {}", message);
    }

    /**
     * 不同消费组的消费者，会消费全部消息
     */
    @RocketMQMessageListener(value = "loveqq-topic-normal", consumerGroup = "repeat_normal_group")
    public void onRepeatMessage(String message) {
        log.info("repeat message: {}", message);
    }

}
