package com.kfyty.loveqq.framework.boot.web.example.controller;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.PostMapping;
import com.kfyty.loveqq.framework.web.core.annotation.PutMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;
import com.kfyty.loveqq.framework.web.core.annotation.bind.PathVariable;
import com.kfyty.loveqq.framework.web.core.annotation.bind.RequestBody;
import com.kfyty.loveqq.framework.web.core.annotation.bind.RequestParam;
import com.kfyty.loveqq.framework.web.core.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@RestController
public class ApiController {

    @GetMapping("/path/{index}")
    public String path(@PathVariable Integer index) {
        return index.toString();
    }

    @PostMapping(produces = "application/octet-stream")
    public byte[] byteArray(@RequestParam String name) {
        return name.getBytes(StandardCharsets.UTF_8);
    }

    @PostMapping(produces = "application/octet-stream")
    public InputStream fileBytes(@RequestBody byte[] file) throws Exception {
        return new ByteArrayInputStream(file);
    }

    @PostMapping(produces = "application/octet-stream")
    public InputStream file(@RequestParam MultipartFile file) throws Exception {
        return file.getInputStream();
    }

    @PutMapping
    public String string(@RequestParam Long id) {
        return id.toString();
    }

    @PostMapping
    public User user(@RequestBody User user) {
        return user;
    }
}
