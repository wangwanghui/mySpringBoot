package com.example.demo.control;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class control {

   /* @RequestMapping("/Hi")
    @ResponseBody*/
    /*public  User Query() {
        System.out.println("------");
       User user=userservice.QueryUser();
       return user;
    }*/

    @RequestMapping("/hello")
    public String Hello() {
      return "helloworld";
    }

}
