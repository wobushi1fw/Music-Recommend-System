package com.example.music_recommend_system.common.request;

import lombok.Data;

// DTO 类，用于接收 stename 请求的 JSON
@Data
public class SetNameRequest {
    private Integer user_id;
    private String user_name;
}