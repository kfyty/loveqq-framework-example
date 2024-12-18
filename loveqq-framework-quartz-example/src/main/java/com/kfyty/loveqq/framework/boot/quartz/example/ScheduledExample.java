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
@Scheduled
@Component
public class ScheduledExample {
    /**
     * 5秒一次，无论上次是否成功
     */
    @Scheduled(fixedRate = 5000)
    public void job1() {
        log.info("execute job1");
    }

    /**
     * 10秒一次，从上次执行结束开始计算
     */
    @Scheduled(fixedDelay = 10000)
    public void job2() {
        log.info("execute job2");
        CommonUtil.sleep(2000);
    }

    /**
     * cron 表达式
     */
    @Scheduled(cron = "*/15 * * ? * *")
    public void job3() {
        log.info("execute cron job3");
    }
}
