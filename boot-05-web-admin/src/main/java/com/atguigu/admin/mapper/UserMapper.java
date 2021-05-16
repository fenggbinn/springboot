package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

//@Mapper//在main类中使用@MapperScan("相应的mapper接口的路径")注解这里就可以不用写@Mapper注解了
public interface UserMapper extends BaseMapper<User> {
    /*public User getUsers(int id);*///使用mybatis-plus 可以不用写普通的方法，已经在base里
    // 面封装好了基本的方法，使用extends BaseMapper<User>调用就好了
    public User getUsers(int id);
}
