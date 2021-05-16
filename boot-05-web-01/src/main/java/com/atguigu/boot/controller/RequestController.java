package com.atguigu.boot.controller;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","传过来了");
        request.setAttribute("code",200);
        return "forward:/success";
    }


    @GetMapping("/params")
    public String testParam(Map<String ,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello","world999");
        model.addAttribute("world","hello999");
        request.setAttribute("message","HelloWorld");

        Cookie cookie = new Cookie("c1","v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg",required = false)String msg,
                       @RequestAttribute(value = "code",required = false)Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Map<String ,Object> map = new HashMap<>();
        map.put("reqMethod_msg",msg1);
        map.put("annotation_msg",msg);

        String hello = request.getParameter("hello");
        String world = request.getParameter("world");
        String message = request.getParameter("message");
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);

        return map;
    }

    /*@GetMapping("/params")
    public String testParam(Map<String ,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello","world999");
        model.addAttribute("world","hello999");
        request.setAttribute("message","HelloWorld");

        Cookie cookie = new Cookie("c1","v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";
    }*/

}
