package com.example.music_recommend_system.common.response;

import com.example.music_recommend_system.entity.Friend;
import lombok.Data;
import java.util.List;

@Data
public class FriendResponse {
    private String status;    // 成功或失败状态
    private String message;   // 返回的消息
    private Integer user_id;  // 用户ID
    private List<Friend> friends;  // 好友列表
}
