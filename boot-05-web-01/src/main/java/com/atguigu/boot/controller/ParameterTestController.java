package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id")Integer id,
                                     @PathVariable("username")String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent")String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age")Integer age,
                                     @RequestParam("inters")List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("_ga")String _ga){

        Map<String,Object> map = new HashMap<>();
       /* map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent", userAgent);
        map.put("header",header);*/
        map.put("age",age);
        map.put("inters",inters);
        map.put("paras",params);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    @PostMapping("/saveuser")
    public Map postMethodContener(Person person){
        Map<String,Object> map = new HashMap<>();
        map.put("person",person);
        return map;
    }

    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low")Integer low,
                        @MatrixVariable("brand")List<String> brand,
                        @PathVariable("path")String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
}
