package com.hdsx.webservice.user.controller;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.service.UserClientService;
import com.hdsx.webservice.user.service.UserManagerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日16:22:11
 * 用户管理和登录等
 **/
@RestController
@RequestMapping(value = "/user")
@Slf4j
@ApiModel(description = "用户管理和登录等相关服务")
public class UserController {

    @Resource
    UserManagerService userManagerService;

    @Resource
    UserClientService userClientService;

    @ApiOperation(value = "新增用户信息", httpMethod = "POST", produces = "application/json", notes = "新增用户信息")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
    public Result addUser(@RequestBody UserBean userBean) {
        try {
            return userManagerService.addUser(userBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.ADD_FAIL);
        }
    }

    @ApiOperation(value = "编辑用户信息", httpMethod = "POST", produces = "application/json", notes = "编辑用户信息")
    @RequestMapping(value = "/editUser", method = RequestMethod.POST, produces = "application/json")
    public Result editUser(@RequestBody UserBean userBean) {
        try {
            return userManagerService.editUser(userBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.ADD_FAIL);
        }
    }

    @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户名")
    @ApiOperation(value = "根据用户名查询用户", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET,produces = "application/json")
    public Result getUserByName(@RequestParam String username){
        try{
            return userManagerService.getUserByName(username);
        } catch (Exception e){
            log.error("服务器异常{}",e.getMessage(),e);
            return ResultUtil.error(ResultCode.QUERY_FAIL);
        }
    }

    @ApiOperation(value = "用户登录", httpMethod = "POST", produces = "application/json", notes = "用户登录")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = "application/json")
    public Result userLogin(@RequestBody UserBean userBean) {
        try {
            return userClientService.userLogin(userBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.LOGIN_FAIL);
        }
    }
}
