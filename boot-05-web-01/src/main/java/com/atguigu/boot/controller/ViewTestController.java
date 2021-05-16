package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;

//@RestController
@Controller
public class ViewTestController {

    @GetMapping("/atguigu")
    public String test1(Model model){
        model.addAttribute("msg","今天是2021年3月24日，今天齐齐哈尔晴，挺暖和的！");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
