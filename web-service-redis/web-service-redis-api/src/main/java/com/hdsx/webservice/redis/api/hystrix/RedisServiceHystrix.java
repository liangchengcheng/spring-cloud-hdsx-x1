package com.hdsx.webservice.redis.api.hystrix;

import com.hdsx.webservice.redis.api.RedisApi;
import com.hdsx.webservice.redis.bean.Redis;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceHystrix implements RedisApi {

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public Boolean add(Redis redis) {
        return false;
    }

    @Override
    public Boolean expire(String key, int value) {
        return false;
    }

    @Override
    public Boolean exists(String key) {
        return false;
    }

    @Override
    public Boolean addForExpireTime(Redis redis) {
        return false;
    }

    @Override
    public Boolean delete(String key) {
        return false;
    }
}
