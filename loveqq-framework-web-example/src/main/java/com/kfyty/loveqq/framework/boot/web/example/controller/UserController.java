package com.kfyty.loveqq.framework.boot.web.example.controller;

import com.kfyty.loveqq.framework.boot.mybatis.example.dao.UserMapper;
import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.data.cache.core.annotation.CacheClear;
import com.kfyty.loveqq.framework.data.cache.core.annotation.Cacheable;
import com.kfyty.loveqq.framework.web.core.annotation.GetMapping;
import com.kfyty.loveqq.framework.web.core.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: 用户控制器，演示了命令式/响应式编程，并统一了缓存使用风格
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Valid
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * sse
     * sse 请求不能使用 {@link Cacheable} 注解
     */
    @GetMapping(produces = "text/event-stream")
    public Flux<User> sse() {
        return Flux.fromIterable(Arrays.asList(1L, 2L, 3L))
                .delayElements(Duration.ofSeconds(1))
                .map(User::new);
    }

    /**
     * jsr 校验测试
     *
     * @param user user
     * @return user
     */
    @GetMapping
    public User test(@Valid User user) {
        return user;
    }

    /**
     * 查询第一个用户，并且缓存 3 秒
     */
    @GetMapping
    @Cacheable(value = "firstUser", ttl = 3)
    public Mono<User> firstUser() {
        return Mono.fromSupplier(() -> this.userMapper.listAll().get(0));
    }

    /**
     * 查询所有用户，并且长期缓存
     */
    @GetMapping
    @Cacheable("listAllUser")
    public Flux<User> listAllUser() {
        return Flux.fromStream(() -> this.userMapper.listAll().stream());
    }

    /**
     * 删除所有用户缓存，并且仅当返回值为 true 时删除
     */
    @GetMapping
    @CacheClear(value = "listAllUser", condition = "retVal", preClearTimeout = 2000)
    public Mono<Boolean> deleteAsync(Long id) {
        return Mono.just(true);
    }

    /**
     * 在事务中查询所有用户，并且长期缓存
     */
    @GetMapping
    @Transactional
    @Cacheable("listAllUserWithTransactional")
    public List<User> listAllUserWithTransactional() {
        return this.userMapper.listAll();
    }

    /**
     * 删除从事务中查询的所有用户缓存，并且仅当返回值为 true 时删除
     */
    @GetMapping("delete")
    @CacheClear(value = "listAllUserWithTransactional", condition = "retVal")
    public boolean delete() {
        return true;
    }
}
