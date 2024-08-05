package com.kfyty.loveqq.framework.boot.feign.example;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@RestController
public class UserFeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/api/listUser")
    public List<User> listUser() {
        return this.userFeignClient.listAllUser();
    }
}
