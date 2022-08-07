package com.kuang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuang.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 28711
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2022-07-24 18:07:16
 * @Entity com.kuang.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User getUser(String username);

}




