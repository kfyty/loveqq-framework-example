package com.kfyty.loveqq.framework.boot.web.example.controller;

import com.kfyty.loveqq.framework.boot.mq.rocket.autoconfig.RocketMQProducer;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.core.support.Pair;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.producer.SendReceipt;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@RestController
public class RocketMQController {
    private static final Pair<String, String> NORMAL = new Pair<>("normal_group", "loveqq-topic-normal");
    private static final Pair<String, String> DELAY = new Pair<>("delay_group", "loveqq-topic-delay");

    @Autowired(required = false)
    private RocketMQProducer rocketMQProducer;

    @GetMapping
    public String send(String name) throws ClientException {
        SendReceipt send = this.rocketMQProducer.prepare()
                .setBody(name)
                .sendTo(NORMAL.getValue());
        return "ok:" + send.getMessageId();
    }

    @GetMapping
    public String sendDelay(Long delay) throws ClientException {
        SendReceipt send = this.rocketMQProducer.prepare()
                .setBody("delay: " + delay)
                .sendDelayTo(DELAY.getValue(), System.currentTimeMillis() + delay);
        log.info("sendDelay: {}", delay);
        return "ok:" + send.getMessageId();
    }
}
