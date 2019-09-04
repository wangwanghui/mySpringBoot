package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Userservice {
      @Autowired
      private UserDao userdao;

      public List<User>  getname(){
        System.out.println("oooooo");
          List<User> list=userdao.QueryUser();
        return list;
        }

    public int insertUser(User user) {
      int  i=  userdao.insertUser(user);
      return i;
    }
}
