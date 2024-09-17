package com.example.music_recommend_system.common.response;

import lombok.Data;

@Data
public class SearchResponse {
    private String status;
    private String message;
    private Integer user_id;
    private Integer obj_user_id;
    private String obj_user_name;
    private Boolean follow;
}
