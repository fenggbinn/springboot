package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    //@Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println("共查询到 "+aLong+" 条数据");
        log.info("查询结果日志打印：\n表中一共查询到 {} 条数据",aLong);
    }

    @Test
    void testUserMapper(){
        /*User user = userMapper.selectById(1001);*/
        User user = userMapper.selectById(1001);
        System.out.println(user);
        log.info("用户信息：{}",user);
    }


}
