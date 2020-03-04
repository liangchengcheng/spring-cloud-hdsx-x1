package com.hdsx.webservice.redis.service.serviceimpl;

import com.hdsx.webservice.redis.bean.Redis;
import com.hdsx.webservice.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public String get(String key) {
        if (template != null && template.hasKey(key)) {
            ValueOperations<String, String> ops = template.opsForValue();
            return ops.get(key);
        }

        return null;
    }

    @Override
    public Boolean add(Redis redis) {
        try {
            ValueOperations<String, String> ops = template.opsForValue();
            ops.set(redis.getKey(), redis.getValue().toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean addForExpireTime(Redis redis) {
        try {
            ValueOperations<String, String> ops = template.opsForValue();
            ops.set(redis.getKey(), redis.getValue().toString(), redis.getSeconds());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(String key) {
        return template.delete(key);
    }

    @Override
    public Boolean expire(String key, int seconds) {
        return template.expire(key, seconds, TimeUnit.SECONDS);
    }

    @Override
    public Boolean exists(String key) {
        return template.hasKey(key);
    }
}
