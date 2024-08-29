package com.kfyty.loveqq.framework.boot.mybatis.example.model;

import com.kfyty.loveqq.framework.boot.validator.annotation.Condition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Condition(value = "id > 0", message = "id 必须大于0")
    private Long id;

    private String username;

    private Integer status;

    private LocalDateTime createTime;

    public User(Long id) {
        this.id = id;
    }
}
