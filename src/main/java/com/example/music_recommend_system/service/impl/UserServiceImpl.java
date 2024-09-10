package com.example.music_recommend_system.service.impl;

import com.example.music_recommend_system.entity.User;
import com.example.music_recommend_system.mapper.UserMapper;
import com.example.music_recommend_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserIdAndPassword(Integer user_id, String password) {
        return userMapper.findByUserIdAndPassword(user_id, password);
    }

    @Override
    public User updateUserName(Integer user_id, String user_name) {
        // 查找用户
        User user = userMapper.findByUserId(user_id);

        if (user != null) {
            // 更新用户名
            int result = userMapper.updateUserName(user_id, user_name);
            if (result > 0) {
                user.setUser_name(user_name); // 更新成功
                return user;
            }
        }

        return new User(); // 更新失败，返回空对象
    }
}
