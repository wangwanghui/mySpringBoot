package com.example.demo.control;

import com.example.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control {
    @Autowired
    private Userservice userservice;

    @RequestMapping("/hello")
    public String Hello() {
        System.out.println("--");
        return "helloworld";
    }

}
