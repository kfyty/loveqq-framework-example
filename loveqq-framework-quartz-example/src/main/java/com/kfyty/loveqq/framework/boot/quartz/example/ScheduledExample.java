package com.kfyty.loveqq.framework.boot.quartz.example;

import com.kfyty.loveqq.framework.boot.quartz.annotation.Scheduled;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Component;
import com.kfyty.loveqq.framework.core.utils.CommonUtil;
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
public class ScheduledExample {
    /**
     * 一秒一次，无论上次是否成功
     */
    @Scheduled(fixedRate = 1000)
    public void job1() {
        log.info("execute job1");
    }

    /**
     * 一秒一次，从上次执行结束开始计算
     */
    @Scheduled(fixedDelay = 1500)
    public void job2() {
        log.info("execute job2");
        CommonUtil.sleep(1000);
    }

    /**
     * cron 表达式
     */
    @Scheduled(cron = "*/5 * * ? * *")
    public void job3() {
        log.info("execute cron job3");
    }
}