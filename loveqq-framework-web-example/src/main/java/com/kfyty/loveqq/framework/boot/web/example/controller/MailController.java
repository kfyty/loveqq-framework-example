package com.kfyty.loveqq.framework.boot.web.example.controller;

import com.kfyty.loveqq.framework.boot.mail.autoconfig.MailService;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@RestController
public class MailController {
    @Autowired
    private MailService mailService;

    @GetMapping("mail/send")
    public Mono<Void> send(String rec, String text) {
        return Mono.fromRunnable(() -> this.mailService.send("test", rec, text));
    }
}
