package com.example.music_recommend_system.service;

import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.User;

import java.util.List;

public interface UserService {

    // 根据 user_id 和 password 查找用户
    User findByUserIdAndPassword(Integer user_id, String password);

    // 更新指定 user_id 的用户名
    User updateUserName(Integer user_id, String user_name);

    // 根据 user_id 查询好友列表
    List<Friend> findFriendsByUserId(Integer user_id);

    // 查找指定 user_id 的用户
    User findByUserId(Integer user_id);

    List<Integer> changeSocialRelationship(Integer userId, Integer objUserId, Boolean follow);

    String getUserName(Integer user_id);
}
