package com.atguigu;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class worldController {
    @RequestMapping("/w")
    public String testOut(){
        return "world";
    }
}
