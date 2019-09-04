package com.example.demo.Dao;

import com.example.demo.entity.CLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CLoginMapper {
    /**通过账号查询用户信息*/
    CLogin FindUserLogin(String username);
}