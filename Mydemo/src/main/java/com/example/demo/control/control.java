package com.example.demo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class control {

    @GetMapping("/a")
    public Object test() {
        return  "wosh是你爸爸";
    }

}
