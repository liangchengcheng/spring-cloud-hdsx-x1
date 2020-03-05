package com.hdsx.webservice.user.api.hystrix;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.user.api.UserServiceApi;
import com.hdsx.webservice.user.bean.ChangePassWordBean;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.bean.UserQueryBean;
import org.springframework.stereotype.Component;

/**
 * 梁铖城
 * 2020年03月04日21:53:05
 * 推荐定义具体错误信息
 */
@Component
public class UserServiceHystrix implements UserServiceApi {

    @Override
    public Result userLogin(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result changePassWord(ChangePassWordBean ChangePassWordBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result addUser(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result editUser(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserByName(String username) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserById(String id) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserList(UserQueryBean userQueryBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

}
