package com.hdsx.webservice.user.api;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.user.api.hystrix.UserManagerServiceHystrix;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.bean.UserQueryBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日13:39:16
 * 用户表基本操作
 **/
@FeignClient(value = "web-service-user-server",path = "/user",fallback = UserManagerServiceHystrix.class)
public interface UserManagerApi {

    @ApiOperation(value = "添加用户", httpMethod = "POST", produces = "application/json", notes = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
    Result addUser(@RequestBody UserBean userBean);

    @ApiOperation(value = "修改用户", httpMethod = "POST", produces = "application/json", notes = "修改用户")
    @RequestMapping(value = "/editUser", method = RequestMethod.POST, produces = "application/json")
    Result editUser(@RequestBody UserBean userBean);

    @ApiOperation(value = "删除用户", httpMethod = "POST", produces = "application/json", notes = "删除用户")
    @RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.GET, produces = "application/json")
    Result deleteUserByUserId(@RequestParam String id);

    @ApiOperation(value = "根据用户名查询用户", httpMethod = "GET", produces = "application/json", notes = "根据用户名查询用户")
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET, produces = "application/json")
    Result getUserByName(@RequestParam String username);

    @ApiOperation(value = "根据ID查询用户", httpMethod = "GET", produces = "application/json", notes = "根据ID查询用户")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "application/json")
    Result getUserById(@RequestParam String id);

    @ApiOperation(value = "模糊查询用户列表", httpMethod = "POST", produces = "application/json", notes = "模糊查询用户")
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST, produces = "application/json")
    Result getUserList(@RequestBody UserQueryBean userQueryBean);
}
