package com.example.music_recommend_system.mapper;

import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

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


    // Check if the relationship already exists
    @Select("SELECT 1 FROM user_friends WHERE user_id = #{user_id} AND friend_id = #{friend_id}")
    Integer checkIfRelationExists(@Param("user_id") Integer user_id, @Param("friend_id") Integer friend_id);

    // Add a new relationship
    @Insert("INSERT INTO user_friends (user_id, friend_id) VALUES (#{user_id}, #{friend_id})")
    void addFriend(@Param("user_id") Integer user_id, @Param("friend_id") Integer friend_id);

    // Remove an existing relationship
    @Delete("DELETE FROM user_friends WHERE user_id = #{user_id} AND friend_id = #{friend_id}")
    void removeFriend(@Param("user_id") Integer user_id, @Param("friend_id") Integer friend_id);

    // Get the list of friend IDs for a user
    @Select("SELECT friend_id FROM user_friends WHERE user_id = #{user_id}")
    List<Integer> getFriendIdsByUserId(@Param("user_id") Integer user_id);

    // 根据 user_id 获取用户的用户名
    @Select("SELECT user_name FROM users WHERE user_id = #{user_id}")
    String getUserName(@Param("user_id") Integer user_id);

}
