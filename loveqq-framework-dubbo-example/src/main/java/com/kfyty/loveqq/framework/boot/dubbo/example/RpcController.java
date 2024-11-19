package com.kfyty.loveqq.framework.boot.dubbo.example;

import com.kfyty.loveqq.framework.boot.dubbo.autoconfig.annotation.DubboComponent;
import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@RestController
@DubboComponent
public class RpcController {
    @Autowired
    private RpcUserServiceImpl nativeUerService;

    @DubboReference(version = "2.0")
    private RpcUserService rpcUserService;

    @GetMapping
    public User rpcUser(Long id) {
        return this.rpcUserService.findById(id);
    }
}
