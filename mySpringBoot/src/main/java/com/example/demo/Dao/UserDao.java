package com.example.demo.Dao;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User QueryUser();
}
