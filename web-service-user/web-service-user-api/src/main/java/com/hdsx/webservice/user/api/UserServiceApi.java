package com.hdsx.webservice.user.api;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.user.api.hystrix.UserServiceHystrix;
import com.hdsx.webservice.user.bean.ChangePassWordBean;
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
 * 2020年02月11日13:57:29
 * 用户登录、修改密码、禁用用户
 **/
@FeignClient(value = "web-service-user-server",path = "/user",fallback = UserServiceHystrix.class)
public interface UserServiceApi {

    @ApiOperation(value = "用户登录服务-1", httpMethod = "POST", produces = "application/json", notes = "用户登录服务")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = "application/json")
    Result userLogin(@RequestBody UserBean userBean);

    /**
     * 暂时不可用
     */
    @ApiOperation(value = "用户修改密码服务", httpMethod = "POST", produces = "application/json", notes = "用户修改密码服务")
    @RequestMapping(value = "/changePassWord", method = RequestMethod.POST, produces = "application/json")
    Result changePassWord(@RequestBody ChangePassWordBean ChangePassWordBean);

    @ApiOperation(value = "添加用户", httpMethod = "POST", produces = "application/json", notes = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
    Result addUser(@RequestBody UserBean userBean);

    @ApiOperation(value = "编辑用户", httpMethod = "POST", produces = "application/json", notes = "编辑用户")
    @RequestMapping(value = "/editUser", method = RequestMethod.POST, produces = "application/json")
    Result editUser(@RequestBody UserBean userBean);

    @ApiOperation(value = "获取用户信息详情通过用户名")
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET, produces = "application/json")
    Result getUserByName(@RequestParam String username);

    /**
     * 忽略 - 暂不可用
     */
    @ApiOperation(value = "获取用户信息详情通过Id")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "application/json")
    Result getUserById(@RequestParam String id);

    @ApiOperation(value = "获取用户列表", httpMethod = "POST", produces = "application/json", notes = "获取用户列表")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = "application/json")
    Result getUserList(@RequestBody UserQueryBean userQueryBean);

}
