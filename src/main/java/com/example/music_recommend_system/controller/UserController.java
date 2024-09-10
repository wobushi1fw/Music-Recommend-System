package com.example.music_recommend_system.controller;

import com.example.music_recommend_system.entity.User;
import com.example.music_recommend_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录功能，使用 GET 请求并返回 LoginResponse
    @GetMapping("/login")
    public LoginResponse login(@RequestParam("user_id") Integer user_id, @RequestParam("password") String password) {
        // 调用服务层进行查询
        User user = userService.findByUserIdAndPassword(user_id, password);

        // 如果查询成功，返回 user_id、user_name 和 password
        if (user != null) {
            return new LoginResponse(user.getUser_id(), user.getUser_name(), user.getPassword());
        }

        // 如果查询失败，返回 user_id 和空的 user_name
        return new LoginResponse(user_id, "", null);
    }

    // 更新用户名功能，使用 POST 请求并返回 SetNameResponse
    @PostMapping("/setname")
    public SetNameResponse setName(@RequestBody SetNameRequest setNameRequest) {
        Integer user_id = setNameRequest.getUser_id();
        String user_name = setNameRequest.getUser_name();

        // 调用服务层进行更新
        User updatedUser = userService.updateUserName(user_id, user_name);

        // 如果更新成功，返回 user_id 和 user_name
        if (updatedUser.getUser_id() != null && updatedUser.getUser_name() != null) {
            return new SetNameResponse(updatedUser.getUser_id(), updatedUser.getUser_name());
        }

        // 如果更新失败，返回空的 user_name
        return new SetNameResponse(user_id, "");
    }

    // 自定义返回的 LoginResponse 类，用于 login 的返回
    public static class LoginResponse {
        private Integer user_id;
        private String user_name;
        private String password;

        public LoginResponse(Integer user_id, String user_name, String password) {
            this.user_id = user_id;
            this.user_name = user_name;
            this.password = password;
        }

        // Getters 和 Setters
        public Integer getUser_id() {
            return user_id;
        }

        public void setUser_id(Integer user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // 自定义返回的 SetNameResponse 类，用于 setname 的返回
    public static class SetNameResponse {
        private Integer user_id;
        private String user_name;

        public SetNameResponse(Integer user_id, String user_name) {
            this.user_id = user_id;
            this.user_name = user_name;
        }

        // Getters 和 Setters
        public Integer getUser_id() {
            return user_id;
        }

        public void setUser_id(Integer user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }

    // DTO 类，用于接收 setname 请求的 JSON
    public static class SetNameRequest {
        private Integer user_id;
        private String user_name;

        public Integer getUser_id() {
            return user_id;
        }

        public void setUser_id(Integer user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }
}
