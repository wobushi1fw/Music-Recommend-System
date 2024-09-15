package com.example.music_recommend_system.controller;

import com.example.music_recommend_system.common.response.LoginResponse;
import com.example.music_recommend_system.common.response.FriendResponse;
import com.example.music_recommend_system.common.response.SetNameResponse;
import com.example.music_recommend_system.common.request.SetNameRequest;
import com.example.music_recommend_system.entity.Friend;
import com.example.music_recommend_system.entity.User;
import com.example.music_recommend_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录功能，使用 GET 请求并返回 LoginResponse
    @GetMapping("/login")
    public LoginResponse login(@RequestParam("user_id") Integer user_id, @RequestParam("password") String password) {

        LoginResponse loginResponse = new LoginResponse();
        // 调用服务层进行查询
        User user = userService.findByUserIdAndPassword(user_id, password);

        // 如果查询成功，返回 user_id、user_name 和 password
        if (user != null) {
            loginResponse.setStatus("success");
            loginResponse.setMessage("Login successful");
            loginResponse.setUser_id(user.getUser_id());
            loginResponse.setUser_name(user.getUser_name());
            return loginResponse;
        }

        // 如果查询失败，返回 user_id 和空的 user_name
        loginResponse.setStatus("error");
        loginResponse.setMessage("Invalid username or password");
        loginResponse.setUser_id(user_id);
        loginResponse.setUser_name(null);
        return loginResponse;
    }

    // 更新用户名功能，使用 POST 请求并返回 SetNameResponse
    @PostMapping("/setname")
    public SetNameResponse setName(@RequestBody SetNameRequest setNameRequest) {
        SetNameResponse setNameResponse = new SetNameResponse();
        Integer user_id = setNameRequest.getUser_id();
        String user_name = setNameRequest.getUser_name();

        // 调用服务层进行更新
        User updatedUser = userService.updateUserName(user_id, user_name);

        // 如果更新成功，返回 user_id 和 user_name
        if (updatedUser.getUser_id() != null && updatedUser.getUser_name() != null) {
            setNameResponse.setStatus("success");
            setNameResponse.setMessage("Reset successful");
            setNameResponse.setUser_id(updatedUser.getUser_id());
            setNameResponse.setUser_name(updatedUser.getUser_name());
            return setNameResponse;
        }

        // 如果更新失败，返回空的 user_name
        setNameResponse.setStatus("error");
        setNameResponse.setMessage("Reset failed");
        setNameResponse.setUser_id(setNameRequest.getUser_id());
        setNameResponse.setUser_name(null);
        return setNameResponse;
    }

    @GetMapping("/friend")
    public FriendResponse getFriends(@RequestParam("user_id") Integer user_id) {
        FriendResponse friendResponse = new FriendResponse();
        List<Friend> friends;

        friends = userService.findFriendsByUserId(user_id);
        System.out.println(1);
        System.out.println(friends.getFirst().getUser_id());
        System.out.println(friends.getFirst().getUser_name());
        try {
            friends = userService.findFriendsByUserId(user_id);
            System.out.println(1);
            System.out.println(friends.getFirst().getUser_id());
            System.out.println(friends.getFirst().getUser_name());
        } catch (Exception e) {
            friendResponse.setStatus("error");
            friendResponse.setMessage("Query friends failed");
            friendResponse.setUser_id(user_id);
            friendResponse.setFriends(null);
            return friendResponse;
        }

        if (friends == null || friends.isEmpty()) {
            friendResponse.setStatus("error");
            friendResponse.setMessage("Query friends failed");
            friendResponse.setFriends(null);
        } else {
            friendResponse.setStatus("success");
            friendResponse.setMessage("Query friends successfully");
            friendResponse.setFriends(friends);
        }

        friendResponse.setUser_id(user_id);
        return friendResponse;
    }

    @PostMapping("/social")
    public Map<String, Object> changeSocialRelationship(@RequestBody Map<String, Object> socialRequest) {
        Integer userId = (Integer) socialRequest.get("user_id");
        Integer objUserId = (Integer) socialRequest.get("obj_user_id");
        Boolean follow = (Boolean) socialRequest.get("follow");

        Map<String, Object> response = new HashMap<>();

        try {
            // Call the service to change the social relationship
            List<Integer> updatedFriendsList = userService.changeSocialRelationship(userId, objUserId, follow);

            response.put("status", "success");
            response.put("message", "Change social relationship successfully");
            response.put("user_id", userId);
            response.put("friend_ids", updatedFriendsList);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Change social relationship failed");
            response.put("user_id", userId);
            response.put("friend_ids", null);
        }

        return response;
    }


}
