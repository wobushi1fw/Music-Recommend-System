package com.example.music_recommend_system.entity;

import java.util.List;

public class RecData {
    private List<Artist> artists;  // 艺术家列表
    private List<Tag> tags;  // 标签列表

    // Getters and Setters
    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}