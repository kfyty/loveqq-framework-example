package com.kfyty.loveqq.framework.boot.mybatis.example.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Data
public class User {
    private Long id;
    private String username;
    private Integer status;
    private LocalDateTime createTime;
}
