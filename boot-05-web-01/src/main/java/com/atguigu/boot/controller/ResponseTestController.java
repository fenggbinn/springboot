package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(34);
        person.setBirth(new Date());
        person.setUserName("的咖啡店");
        return person;
    }
}
