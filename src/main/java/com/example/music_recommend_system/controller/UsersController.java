package com.example.music_recommend_system.controller;

import com.example.music_recommend_system.entity.Users;
import com.example.music_recommend_system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyy
 * @since 2024-09-10
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public HashMap<String, String> login(@RequestBody Users users) {
        HashMap<String, String> res = new HashMap<>();

        // 使用 lambdaQuery 来进行用户 ID 和密码的查询
        List<Users> list = usersService.lambdaQuery()
                .eq(Users::getUserId, users.getUserId())
                .eq(Users::getPassword, users.getPassword())
                .list();

        // 检查查询结果
        if (!list.isEmpty()) {
            Users user1 = list.get(0);  // 获取第一个用户
            String userName = user1.getUserName();

            res.put("status", "success");
            res.put("message", "Login successful");
            res.put("username", userName);
            return res;
        }

        res.put("status", "error");
        res.put("message", "Invalid username or password");
        return res;
    }
}
