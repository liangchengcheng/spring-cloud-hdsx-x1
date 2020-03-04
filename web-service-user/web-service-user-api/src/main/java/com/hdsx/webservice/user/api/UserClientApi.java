package com.hdsx.webservice.user.api;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.user.api.hystrix.UserClientServiceHystrix;
import com.hdsx.webservice.user.bean.ChangePassWordBean;
import com.hdsx.webservice.user.bean.UserBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日13:57:29
 * 用户登录、修改密码、禁用用户
 **/
@FeignClient(value = "web-service-user-server",path = "/user",fallback = UserClientServiceHystrix.class)
public interface UserClientApi {

    @ApiOperation(value = "用户登录服务", httpMethod = "POST", produces = "application/json", notes = "用户登录服务")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = "application/json")
    Result userLogin(@RequestBody UserBean userBean);

    @ApiOperation(value = "用户修改密码服务", httpMethod = "POST", produces = "application/json", notes = "用户修改密码服务")
    @RequestMapping(value = "/changePassWord", method = RequestMethod.POST, produces = "application/json")
    Result changePassWord(@RequestBody ChangePassWordBean ChangePassWordBean);

    @ApiOperation(value = "禁用用户服务", httpMethod = "POST", produces = "application/json", notes = "禁用用户服务")
    @RequestMapping(value = "/forbiddenUser", method = RequestMethod.POST, produces = "application/json")
    Result forbiddenUser(@RequestBody UserBean userBean);

}
