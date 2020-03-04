package com.hdsx.webservice.user.api.hystrix;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.user.api.UserManagerApi;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.bean.UserQueryBean;
import org.springframework.stereotype.Component;

@Component
public class UserManagerServiceHystrix implements UserManagerApi {

    @Override
    public Result addUser(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result editUser(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result deleteUserByUserId(String id) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserByName(String username) {
        return ResultUtil.error(ResultCode.QUERY_FAIL);
    }

    @Override
    public Result getUserById(String id) {
        return ResultUtil.error(ResultCode.QUERY_FAIL);
    }

    @Override
    public Result getUserList(UserQueryBean userQueryBean) {
        return ResultUtil.error(ResultCode.QUERY_FAIL);
    }
}
