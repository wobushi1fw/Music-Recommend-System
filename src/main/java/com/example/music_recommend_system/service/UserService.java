package com.example.music_recommend_system.service;

import com.example.music_recommend_system.entity.User;

public interface UserService {
    User findByUserIdAndPassword(Integer user_id, String password);
    User updateUserName(Integer user_id, String user_name); // 新增方法
}
