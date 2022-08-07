package com.kuang.service.impl;

import com.kuang.entity.User;
import com.kuang.mapper.UserMapper;
import com.kuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 28711
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-07-24 18:07:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public UserServiceImpl() {
        super();
    }

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUser(username);
    }
}




