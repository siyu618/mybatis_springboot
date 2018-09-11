package com.study.mybatis_springboot.service;

import com.study.mybatis_springboot.model.User;

import java.util.List;

public interface UserServiceI {
    public List<User> getUserInfo();

    public User getUserById(long id);
    public int update(User user);
    public int insert(User user);
    public int delete(User user);
}
