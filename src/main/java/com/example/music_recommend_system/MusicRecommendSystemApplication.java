package com.example.music_recommend_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.music_recommend_system.mapper")
public class MusicRecommendSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicRecommendSystemApplication.class, args);
    }

}
