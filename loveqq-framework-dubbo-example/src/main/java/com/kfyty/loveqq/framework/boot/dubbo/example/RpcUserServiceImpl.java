package com.kfyty.loveqq.framework.boot.dubbo.example;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@DubboService(version = "2.0")
public class RpcUserServiceImpl implements RpcUserService {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("rpc user");
        return user;
    }
}
