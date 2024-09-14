package com.example.music_recommend_system.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
public class LoginResponse {
    private String status;
    private String message;
    private Integer user_id;
    private String user_name;

}