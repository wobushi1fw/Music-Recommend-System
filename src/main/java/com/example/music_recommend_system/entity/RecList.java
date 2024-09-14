package com.example.music_recommend_system.entity;

import java.util.List;

public class RecList {
    private Integer user_id;  // 用户ID
    private RecData rec_data;  // 推荐数据，包括artists和tags

    // Getters
    public Integer getUser_id() {
        return user_id;
    }

    public RecData getRec_data() {
        return rec_data;
    }



    // Setters
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setRec_data(RecData rec_data) {
        this.rec_data = rec_data;
    }

}
