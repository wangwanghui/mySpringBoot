package com.example.demo.service;

import com.example.demo.Dao.CLoginMapper;
import com.example.demo.entity.CLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CLoginService {
    @Autowired
    CLoginMapper cLoginMapper;

    /**
     * 通过账号查询用户信息
     */
    public CLogin FindUserLogin(String username) {
        System.out.println("------"+cLoginMapper.FindUserLogin(username));
        return cLoginMapper.FindUserLogin(username);
    }


}
