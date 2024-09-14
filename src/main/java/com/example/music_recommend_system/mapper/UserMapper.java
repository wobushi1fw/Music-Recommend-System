package com.example.music_recommend_system.mapper;

import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {



    @Select("SELECT u.user_id, u.user_name " +
            "FROM user_friends uf " +
            "JOIN users u ON uf.friend_id = u.user_id " +
            "WHERE uf.user_id = #{user_id}")
    List<Friend> findFriendsByUserId(@Param("user_id") Integer user_id);


    // 根据 user_id 和 password 查找用户
    @Select("SELECT * FROM users WHERE user_id = #{user_id} AND password = #{password}")
    User findByUserIdAndPassword(@Param("user_id") Integer user_id, @Param("password") String password);

    @Update("UPDATE users SET user_name = #{user_name} WHERE user_id = #{user_id}")
    int updateUserName(@Param("user_id") Integer user_id, @Param("user_name") String user_name);

    // 查找用户
    @Select("SELECT * FROM users WHERE user_id = #{user_id}")
    User findByUserId(@Param("user_id") Integer user_id);
}
