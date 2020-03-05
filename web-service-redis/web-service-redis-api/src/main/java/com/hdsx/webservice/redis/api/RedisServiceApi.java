package com.hdsx.webservice.redis.api;

import com.hdsx.webservice.redis.api.hystrix.RedisServiceHystrix;
import com.hdsx.webservice.redis.bean.Redis;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日10:59:41
 * Redis FeignClient
 */
@FeignClient(value = "web-service-redis-server", path = "redis", fallback = RedisServiceHystrix.class)
public interface RedisServiceApi {

    @ApiOperation("获取redis中存储的值")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    String get(@RequestParam("key") String key);

    @ApiOperation("添加数据保存到redis中")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    Boolean add(@RequestBody Redis redis);

    @ApiOperation("删除缓存")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    Boolean delete(@RequestParam("key") String key);

    @ApiOperation("到时自动销毁redis中存储的数据")
    @RequestMapping(value = "/expire", method = RequestMethod.GET)
    Boolean expire(@RequestParam("key") String key, @RequestParam("value") int value);

    @ApiOperation("判断key是否存在")
    @RequestMapping(value = "/exists", method = RequestMethod.GET)
    Boolean exists(@RequestParam("key") String key);

    @ApiOperation("添加数据保存到redis中并设置过期时间，单位为秒")
    @RequestMapping(value = "/addForExpireTime", method = RequestMethod.POST)
    Boolean addForExpireTime(@RequestBody Redis redis);

}
