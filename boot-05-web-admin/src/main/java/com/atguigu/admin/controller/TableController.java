package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.bean.User_last;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        /*List<User_last> users = Arrays.asList(new User_last("zs", "122323"),
                new User_last("ls", "3232"),
                new User_last("fkdkf", "3434"),
                new User_last("eer", "098"));*/
//        List<User> users = userService.list();
//        model.addAttribute("users",users);
        Page<User> pa = new Page<>(pn,5);
        Page<User> page = userService.page(pa,null);
        long current = page.getCurrent();
        long pages = page.getPages();
        List<User> records = page.getRecords();
        long total = page.getTotal();
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    //删除
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
}
