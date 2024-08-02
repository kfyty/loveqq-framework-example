package com.kfyty.loveqq.framework.boot.web.example.controller;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.web.core.annotation.Controller;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.request.support.Model;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Controller
public class ViewController {
    /**
     * {@link GetMapping} 不写路径，默认映射到方法名称
     * 返回值表示访问 hello.html 视图
     */
    @GetMapping
    public String hello(Model model, String name, Integer status) {
        User user = new User();
        user.setUsername(name);
        user.setStatus(status);
        model.addAttribute("user", user);
        return "hello";
    }
}
