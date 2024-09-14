package com.example.music_recommend_system.entity;

public class Feedback {

    private Integer user_id;           // 用户ID
    private Integer feedback_artist_id; // 艺术家ID（可选）
    private Boolean like_artist;       // 是否喜欢该艺术家
    private Boolean dislike_artist;    // 是否不喜欢该艺术家
    private Integer feedback_tag_id;   // 标签ID（可选）
    private Boolean like_tag;          // 是否喜欢该标签
    private Boolean dislike_tag;       // 是否不喜欢该标签

    // Getters and Setters
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFeedback_artist_id() {
        return feedback_artist_id;
    }

    public void setFeedback_artist_id(Integer feedback_artist_id) {
        this.feedback_artist_id = feedback_artist_id;
    }

    public Boolean getLike_artist() {
        return like_artist;
    }

    public void setLike_artist(Boolean like_artist) {
        this.like_artist = like_artist;
    }

    public Boolean getDislike_artist() {
        return dislike_artist;
    }

    public void setDislike_artist(Boolean dislike_artist) {
        this.dislike_artist = dislike_artist;
    }

    public Integer getFeedback_tag_id() {
        return feedback_tag_id;
    }

    public void setFeedback_tag_id(Integer feedback_tag_id) {
        this.feedback_tag_id = feedback_tag_id;
    }

    public Boolean getLike_tag() {
        return like_tag;
    }

    public void setLike_tag(Boolean like_tag) {
        this.like_tag = like_tag;
    }

    public Boolean getDislike_tag() {
        return dislike_tag;
    }

    public void setDislike_tag(Boolean dislike_tag) {
        this.dislike_tag = dislike_tag;
    }
}
