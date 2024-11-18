package org.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisService {

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void insertHash(String key, Map<String, String> hash) {
        // 获取操作哈希的HashOperations实例
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();

        // 插入哈希数据到Redis中
        hashOperations.putAll(key, hash);
    }
}