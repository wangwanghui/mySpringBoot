package com.example.demo.Dao;

import com.example.demo.entity.Role;
import com.example.demo.entity.Permission;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    /*List<User> QueryUser();

    int insertUser(User user);*/
    //角色
    Role getRolesByUserName(String userName);

    //权限
    Permission getPermissionsByUserName(String userName);

    //用户
    User getUserByUserName(String userName);

}
