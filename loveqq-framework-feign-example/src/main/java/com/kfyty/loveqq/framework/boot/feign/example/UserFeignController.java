package com.kfyty.loveqq.framework.boot.feign.example;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.PostMapping;
import com.kfyty.loveqq.framework.web.core.annotation.PutMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RequestMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;
import com.kfyty.loveqq.framework.web.core.annotation.bind.PathVariable;
import com.kfyty.loveqq.framework.web.core.annotation.bind.RequestBody;
import com.kfyty.loveqq.framework.web.core.annotation.bind.RequestParam;
import com.kfyty.loveqq.framework.web.core.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@RestController
@RequestMapping("/api")
public class UserFeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 查询用户示例
     */
    @GetMapping("/listUser")
    public List<User> listUser() {
        return this.userFeignClient.listAllUser();
    }

    /**
     * 路径参数示例
     */
    @GetMapping("/path/{index}")
    public String path(@PathVariable Integer index) {
        String path = this.userFeignClient.path(index);
        if (Objects.equals(path, index.toString())) {
            return path;
        }
        throw new IllegalStateException();
    }

    /**
     * 字节数组返回值示例
     */
    @PostMapping
    public String byteArray(@RequestParam String name) {
        byte[] bytes = this.userFeignClient.byteArray(name);
        if (Arrays.equals(bytes, name.getBytes(StandardCharsets.UTF_8))) {
            return new String(bytes);
        }
        throw new IllegalStateException();
    }

    /**
     * 字节数组文件上传参数示例
     */
    @PostMapping
    public String fileBytes(@RequestParam MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        byte[] bytes1 = this.userFeignClient.fileBytes(bytes);
        if (Arrays.equals(bytes, bytes1)) {
            return new String(bytes1);
        }
        throw new IllegalStateException();
    }

    /**
     * MultipartFile 文件上传参数示例
     */
    @PostMapping
    public String file(@RequestParam MultipartFile file) throws Exception {
        byte[] bytes1 = this.userFeignClient.file(file);
        return new String(bytes1);
    }

    /**
     * 返回字符串示例
     */
    @PutMapping
    public String string(@RequestParam Long id) {
        String string = this.userFeignClient.string(id);
        if (string.equals(id.toString())) {
            return string;
        }
        throw new IllegalStateException();
    }

    /**
     * json 示例
     */
    @PostMapping
    public User user(@RequestBody User user) {
        User user1 = this.userFeignClient.user(user);
        if (user1.equals(user)) {
            return user1;
        }
        throw new IllegalStateException();
    }
}
