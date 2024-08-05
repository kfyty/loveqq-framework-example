package com.kfyty.loveqq.framework.boot.feign.example;

import com.kfyty.loveqq.framework.boot.feign.autoconfig.annotation.FeignClient;
import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import feign.RequestLine;

import java.util.List;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@FeignClient("${k.application.name}")
public interface UserFeignClient {
    @RequestLine("GET /listAllUser")
    List<User> listAllUser();
}
