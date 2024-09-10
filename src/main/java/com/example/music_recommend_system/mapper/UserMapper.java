package com.example.music_recommend_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music_recommend_system.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends BaseMapper<User> {
    // 自定义查询语句，根据 userId 和 password 查询
    @Select("SELECT * FROM users WHERE user_id = #{user_id}")
    User findByUserIdAndPassword(@Param("user_id") Integer user_id, @Param("password") String password);

    // 根据 user_id 更新 user_name
    @Update("UPDATE users SET user_name = #{user_name} WHERE user_id = #{user_id}")
    int updateUserName(@Param("user_id") Integer user_id, @Param("user_name") String user_name);

    // 查找用户
    @Select("SELECT * FROM users WHERE user_id = #{user_id}")
    User findByUserId(@Param("user_id") Integer user_id);
}
