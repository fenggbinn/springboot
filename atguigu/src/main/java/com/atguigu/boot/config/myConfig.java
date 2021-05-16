package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({User.class,Pet.class })
//@ConditionalOnBean(name = "pet01")
@ConditionalOnMissingBean(name = "user1")
@Configuration(proxyBeanMethods = false)//单例实例使用设置为false，如果有人调用方法使用默认的true；
public class myConfig {

    @Bean("pet01")
    public Pet pet1(){
        return new Pet("Tomcat");
    }

    @Bean
    public User user1(){
        return new User("tom",23);
    }
}
