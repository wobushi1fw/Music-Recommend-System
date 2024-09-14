package com.example.music_recommend_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Friend extends User {

    // 使用 @JsonIgnore 注解，确保序列化时不会包含 password 字段
    @Override
    @JsonIgnore
    public String getPassword() {
        return super.getPassword();
    }

}
