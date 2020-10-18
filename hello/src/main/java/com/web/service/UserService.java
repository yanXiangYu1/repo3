package com.web.service;

import com.web.mapper.UserMapper;
import com.web.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void addUser(){
        System.out.println("service调用了!!!!");
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        return list;
    }

    public User findUser(String username) {
        User user  = userMapper.findUser(username);
        return user;
    }

    public User findUserByName(String username) {
        return new User();
    }
}
