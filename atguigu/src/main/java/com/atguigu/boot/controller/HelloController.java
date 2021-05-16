package com.atguigu.boot.controller;


/*@Controller
@ResponseBody*/

import com.atguigu.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于上面两个注解
public class HelloController {
    @RequestMapping(value = "/hello")
    public String handle01(){
        return "Hello springboot2！";
    }

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car1(){
        return car;
    }
}
