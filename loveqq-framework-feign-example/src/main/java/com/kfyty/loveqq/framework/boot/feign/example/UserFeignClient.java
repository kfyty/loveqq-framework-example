package com.kfyty.loveqq.framework.boot.feign.example;

import com.kfyty.loveqq.framework.boot.feign.autoconfig.annotation.FeignClient;
import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.PostMapping;
import com.kfyty.loveqq.framework.web.core.annotation.PutMapping;
import com.kfyty.loveqq.framework.web.core.annotation.bind.PathVariable;
import com.kfyty.loveqq.framework.web.core.annotation.bind.RequestBody;
import com.kfyty.loveqq.framework.web.core.annotation.bind.RequestParam;
import com.kfyty.loveqq.framework.web.core.multipart.MultipartFile;
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
    /**
     * 查询用户示例
     */
    @RequestLine("GET /listAllUser")
    List<User> listAllUser();

    /**
     * 路径参数示例
     */
    @GetMapping("/path/{index}")
    String path(@PathVariable Integer index);

    /**
     * 字节数组返回值示例
     */
    @PostMapping
    byte[] byteArray(@RequestParam String name);

    /**
     * 字节数组文件上传参数示例，无需 multipart/form-data，直接使用请求体
     */
    @PostMapping
    byte[] fileBytes(@RequestBody byte[] file);

    /**
     * MultipartFile 文件上传参数示例，需要使用 multipart/form-data
     */
    @PostMapping(produces = "multipart/form-data")
    byte[] file(@RequestParam MultipartFile file);

    /**
     * 返回字符串示例
     */
    @PutMapping
    String string(@RequestParam Long id);

    /**
     * json 示例
     */
    @PostMapping
    User user(@RequestBody User user);
}
