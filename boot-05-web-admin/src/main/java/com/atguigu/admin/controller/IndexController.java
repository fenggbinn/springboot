package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.bean.User_last;
import com.atguigu.admin.service.impl.CityServiceImpl;
import com.atguigu.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CityServiceImpl cityService;

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/index_alt")
    public String main(/*String username,String password*/User_last user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            //return "redirect:/index_alt.html";
            return "index_alt";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
       // return "index_alt";
    }

    @GetMapping("/index_alt.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");

        if(loginUser!=null){
            return "index_alt";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }
    @GetMapping("/index.html")
    public String mainPage2(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");

        if(loginUser!=null){
            return "index";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

    @ResponseBody
    @GetMapping("/getUser")
    public User getUser(@RequestParam("id")Integer id){
        return userService.getUsers(id);
    }

    @ResponseBody
    @GetMapping("/getCity")
    public City getCity(@RequestParam("cityId")Integer cityId){
        return cityService.getCity(cityId);
    }

/*
    @RequestMapping("/insertCity")
    public void insertCity(City city){
        cityService.insertCity(city);
    }*/

    @RequestMapping("/insertCity")
    public void insertCity(@RequestParam("cityId")Integer cityId,
                           @RequestParam("cityName")String cityName){
        cityService.insertCity(cityId,cityName);
    }
}
