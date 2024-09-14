package com.example.music_recommend_system.service;

import com.example.music_recommend_system.entity.Feedback;
import com.example.music_recommend_system.entity.RecList;

public interface RecommendService {
    // 根据 user_id 查询推荐列表
    RecList findByUserIdForRec(Integer user_id);

    // 处理艺术家反馈
    boolean handleArtistFeedback(Feedback feedback);

    // 处理标签反馈
    boolean handleTagFeedback(Feedback feedback);
}
