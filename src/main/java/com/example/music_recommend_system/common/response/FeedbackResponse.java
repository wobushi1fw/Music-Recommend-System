package com.example.music_recommend_system.common.response;

import lombok.Data;

@Data
public class FeedbackResponse {
    private String status;
    private String message;
    private Integer user_id;
    private Integer feedback_artist_id;
    private Boolean like_artist;
    private Boolean dislike_artist;
    private Integer feedback_tag_id;
    private Boolean like_tag;
    private Boolean dislike_tag;
}
