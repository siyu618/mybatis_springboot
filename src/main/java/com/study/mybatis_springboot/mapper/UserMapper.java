package com.study.mybatis_springboot.mapper;

import com.study.mybatis_springboot.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> findUserInfo();

    User getUserById(@Param("id") long id);
    int updateUser(@Param("user") User user);
    int insertUser(@Param("user") User user);
    int deleteUserById(@Param("id") long id);
}
