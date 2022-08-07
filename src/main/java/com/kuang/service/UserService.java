package com.kuang.service;

import com.kuang.entity.User;

/**
 * @author 28711
 * @description 针对表【user】的数据库操作Service
 * @createDate 2022-07-24 18:07:16
 */
public interface UserService {

    /**
     * 查询用户数据
     * @param username
     * @return
     */
    public User getUserInfo(String username);

}
