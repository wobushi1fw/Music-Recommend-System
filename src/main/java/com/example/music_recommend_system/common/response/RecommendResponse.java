package com.example.music_recommend_system.common.response;

import com.example.music_recommend_system.entity.RecData;
import lombok.Data;

@Data
public class RecommendResponse {
    private String status;    // 成功或失败状态
    private String message;   // 返回的消息
    private Integer user_id;  // 用户ID
    private RecData rec_data; // 推荐数据（包含artists和tags）
}
