package com.example.music_recommend_system.service.impl;

import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.User;
import com.example.music_recommend_system.mapper.UserMapper;
import com.example.music_recommend_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User user = userMapper.findByUserId(user_id);

        if (user != null) {
            System.out.println(user);
            int result = userMapper.updateUserName(user_id, user_name);
            System.out.println(result);
            if (result != 0) {
                user.setUser_name(user_name);
                return user;
            }
        }

        return new User(); // 更新失败，返回空对象
    }

    @Override
    public List<Friend> findFriendsByUserId(Integer user_id) {
        return userMapper.findFriendsByUserId(user_id);
    }

    @Override
    public User findByUserId(Integer user_id) {
        return userMapper.findByUserId(user_id);
    }
}
