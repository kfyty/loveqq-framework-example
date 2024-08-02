package com.kfyty.loveqq.framework.boot.mybatis.example.dao;

import com.kfyty.loveqq.framework.boot.mybatis.example.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 描述:
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Mapper
public interface UserMapper {
    List<User> listAll();
}
