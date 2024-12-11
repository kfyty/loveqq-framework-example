package com.kfyty.loveqq.framework.boot.web.example.mq;

import com.kfyty.loveqq.framework.boot.mq.rocket.autoconfig.annotation.RocketMQMessageListener;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Component;
import com.kfyty.loveqq.framework.core.utils.NIOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.consumer.ConsumeResult;
import org.apache.rocketmq.client.apis.consumer.MessageListener;
import org.apache.rocketmq.client.apis.message.MessageView;

/**
 * 描述: mq 类级别示例
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@Component
@RocketMQMessageListener(value = "loveqq-topic-delay", consumerGroup = "delay_group")
public class DelayMessageConsumer implements MessageListener {

    @Override
    public ConsumeResult consume(MessageView messageView) {
        log.info("delay message: " + new String(NIOUtil.read(messageView.getBody())));
        return ConsumeResult.SUCCESS;
    }
}
