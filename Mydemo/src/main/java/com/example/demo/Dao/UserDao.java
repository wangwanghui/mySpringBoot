package com.example.demo.Dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

  List<User> QueryUser();

   int insertUser(User user);
}
