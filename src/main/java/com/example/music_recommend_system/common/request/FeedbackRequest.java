package com.example.music_recommend_system.common.request;

import lombok.Data;

// DTO 类，用于接收反馈请求的 JSON
@Data
public class FeedbackRequest {
    private Integer user_id;
    private Integer feedback_artist_id;  // 艺术家ID
    private Boolean like_artist;  // 用户是否喜欢艺术家
    private Boolean dislike_artist;  // 用户是否不喜欢艺术家
    private Integer feedback_tag_id;  // 标签ID
    private Boolean like_tag;  // 用户是否喜欢标签
    private Boolean dislike_tag;  // 用户是否不喜欢标签
}
