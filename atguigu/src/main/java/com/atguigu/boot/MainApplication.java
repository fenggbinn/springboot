package com.atguigu.boot;

import com.atguigu.boot.bean.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.atguigu")//通过这个注解告诉这个是一个springboot应用
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        Pet pet01 = run.getBean("pet01", Pet.class);
        System.out.println(pet01);

        boolean pet = run.containsBean("pet01");
        System.out.println("容器中pet组件："+pet);

        boolean cat = run.containsBean("user1");
        System.out.println("容器中cat组件："+cat);
    }
}
