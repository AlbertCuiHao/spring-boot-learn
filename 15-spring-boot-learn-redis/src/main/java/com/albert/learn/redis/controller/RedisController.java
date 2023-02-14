package com.albert.learn.redis.controller;

import com.albert.learn.redis.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/set")
    public UserEntity set() {
        UserEntity entity = new UserEntity();
        entity.setAge(15);
        entity.setName("Albert");
        redisTemplate.opsForValue().set(entity.getName(), entity);
        return entity;
    }

    @GetMapping("/get")
    public UserEntity get() {
        return (UserEntity) redisTemplate.opsForValue().get("Albert");
    }
}
