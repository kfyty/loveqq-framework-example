package com.kfyty.loveqq.framework.boot.dubbo.example;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
public interface RpcUserService {
    User findById(Long id);
}
