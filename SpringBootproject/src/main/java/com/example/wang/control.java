package com.example.wang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/my")
public class control {
    @RequestMapping("/Hi")
    public String sayHello() {
        return "helloworld.html";
    }

}
