package com.example.music_recommend_system.service.impl;

import com.example.music_recommend_system.entity.Users;
import com.example.music_recommend_system.mapper.UsersMapper;
import com.example.music_recommend_system.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyy
 * @since 2024-09-10
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;
}
