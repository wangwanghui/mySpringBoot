package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Autowired
    private UserDao userdao;

    public User QueryUser(){
        User user= userdao.QueryUser();
        return user;
    }
}
