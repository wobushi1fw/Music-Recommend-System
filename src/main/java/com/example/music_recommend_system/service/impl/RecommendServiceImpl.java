package com.example.music_recommend_system.service.impl;

import com.example.music_recommend_system.entity.RecList;
import com.example.music_recommend_system.entity.RecData;
import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.Artist;
import com.example.music_recommend_system.entity.Tag;
import com.example.music_recommend_system.entity.Feedback;
import com.example.music_recommend_system.mapper.RecommendMapper;
import com.example.music_recommend_system.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;

    // 查询推荐列表，包括朋友、艺术家和标签
    @Override
    public RecList findByUserIdForRec(Integer user_id) {
        // 查询朋友、艺术家和标签
        List<Artist> artists = recommendMapper.findArtistsByUserId(user_id);
        List<Tag> tags = recommendMapper.findTagsByUserId(user_id);

        // 如果查询的 artists 或 tags 为空列表，则设置为 null
        if (artists == null || artists.isEmpty()) {
            artists = null;
        }
        if (tags == null || tags.isEmpty()) {
            tags = null;
        }

        // 构建 RecData 对象，包含艺术家和标签
        RecData recData = new RecData();
        recData.setArtists(artists);
        recData.setTags(tags);

        // 构建 RecList 对象，将 user_id、推荐数据和朋友列表设置到对象中
        RecList recList = new RecList();
        recList.setUser_id(user_id);
        recList.setRec_data(recData);

        return recList;
    }

    // 处理艺术家反馈
    @Override
    public boolean handleArtistFeedback(Feedback feedback) {
        if (feedback.getLike_artist() != null && feedback.getLike_artist()) {
            // 用户喜欢艺术家，增加权重
            return recommendMapper.updateArtistWeight(feedback.getUser_id(), feedback.getFeedback_artist_id(), 100);
        } else if (feedback.getDislike_artist() != null && feedback.getDislike_artist()) {
            // 用户不喜欢艺术家，减少权重，确保最小为0
            return recommendMapper.updateArtistWeight(feedback.getUser_id(), feedback.getFeedback_artist_id(), -100);
        }
        return false;
    }

    // 处理标签反馈
    @Override
    public boolean handleTagFeedback(Feedback feedback) {
        if (feedback.getLike_tag() != null && feedback.getLike_tag()) {
            // 用户喜欢标签，增加权重
            return recommendMapper.updateTagWeight(feedback.getUser_id(), feedback.getFeedback_tag_id(), 2);
        } else if (feedback.getDislike_tag() != null && feedback.getDislike_tag()) {
            // 用户不喜欢标签，减少权重，确保最小为0
            return recommendMapper.updateTagWeight(feedback.getUser_id(), feedback.getFeedback_tag_id(), -2);
        }
        return false;
    }
}
