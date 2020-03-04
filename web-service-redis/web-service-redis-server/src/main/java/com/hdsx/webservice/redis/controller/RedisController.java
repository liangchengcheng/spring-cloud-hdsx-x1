package com.hdsx.webservice.redis.controller;

import com.hdsx.webservice.redis.bean.Redis;
import com.hdsx.webservice.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日11:10:51
 * Redis 对外访问
 */
@RestController
@RequestMapping(value = "/redis")
@Slf4j
@Api(value = "redis服务",description = "Redis操作服务")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @ApiOperation("获取redis中存储的值")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("key") String key) {
        return redisService.get(key);
    }

    @ApiOperation("添加数据保存到redis中")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody Redis redis) {
        return redisService.add(redis);
    }

    @ApiOperation("删除redis中存储的数据")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Boolean delete(@RequestParam("key") String key) {
        return redisService.delete(key);
    }

    @ApiOperation("到时自动销毁redis中存储的数据")
    @RequestMapping(value = "/expire", method = RequestMethod.GET)
    public Boolean expire(@RequestParam("key") String key, @RequestParam("value") int value) {
        return redisService.expire(key, value);
    }

    @ApiOperation("判断key是否存在")
    @RequestMapping(value = "/exists", method = RequestMethod.GET)
    public Boolean exists(@RequestParam("key") String key) {
        return redisService.exists(key);
    }

    @ApiOperation("添加数据保存到redis中并设置过期时间，单位为秒")
    @RequestMapping(value = "/addForExpireTime", method = RequestMethod.POST)
    public Boolean addForExpireTime(@RequestBody Redis redis) {
        return redisService.addForExpireTime(redis);
    }
}
