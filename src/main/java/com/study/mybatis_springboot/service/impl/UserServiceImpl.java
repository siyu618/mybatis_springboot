package com.study.mybatis_springboot.service.impl;

import com.study.mybatis_springboot.mapper.UserMapper;
import com.study.mybatis_springboot.model.User;
import com.study.mybatis_springboot.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getUserInfo() {
        return mapper.findUserInfo();
    }

    @Override
    public User getUserById(long id) {
        return mapper.getUserById(id);
    }

    @Override
    public int update(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public int insert(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public int delete(User user) {
        return mapper.deleteUserById(user.getId());
    }


}
