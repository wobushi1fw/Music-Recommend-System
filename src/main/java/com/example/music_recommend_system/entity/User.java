package com.example.music_recommend_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")  // 对应数据库中的表名
public class User {

    // 直接使用与数据库表字段一致的命名
    private Integer user_id;
    private String user_name;
    private String password;
}
