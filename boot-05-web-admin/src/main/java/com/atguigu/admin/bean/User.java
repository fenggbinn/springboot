package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("user")
public class User {
   // @TableId("id")
    private Integer id;
    private String name;
    private String password;
    private Date date;
    //private Blob blob;
    private Blob photo;
}
