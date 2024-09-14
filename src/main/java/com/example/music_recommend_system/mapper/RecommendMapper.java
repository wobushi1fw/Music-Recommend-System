package com.example.music_recommend_system.mapper;

import com.example.music_recommend_system.entity.Artist;
import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.Tag;
import com.example.music_recommend_system.entity.RecList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RecommendMapper {

    // 查询指定用户的艺术家列表
    @Select("SELECT a.id, a.name " +
            "FROM user_recartists ua " +
            "JOIN artists a ON ua.artist_id = a.id " +
            "WHERE ua.user_id = #{user_id}")
    List<Artist> findArtistsByUserId(@Param("user_id") Integer user_id);

    // 查询指定用户的标签列表
    @Select("SELECT t.id, t.name " +
            "FROM user_rectags ut " +
            "JOIN tags t ON ut.tag_id = t.id " +
            "WHERE ut.user_id = #{user_id}")
    List<Tag> findTagsByUserId(@Param("user_id") Integer user_id);

    // 更新艺术家的权重
    @Update("UPDATE user_artists SET weight = GREATEST(weight + #{value}, 0) WHERE user_id = #{userId} AND artist_id = #{artistId}")
    boolean updateArtistWeight(@Param("userId") Integer userId, @Param("artistId") Integer artistId, @Param("value") Integer value);

    // 更新标签的权重
    @Update("UPDATE user_tags SET weight = GREATEST(weight + #{value}, 0) WHERE user_id = #{userId} AND tag_id = #{tagId}")
    boolean updateTagWeight(@Param("userId") Integer userId, @Param("tagId") Integer tagId, @Param("value") Integer value);
}
