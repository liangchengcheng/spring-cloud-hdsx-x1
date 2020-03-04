package com.hdsx.webservice.user.api.hystrix;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.user.api.UserClientApi;
import com.hdsx.webservice.user.bean.ChangePassWordBean;
import com.hdsx.webservice.user.bean.UserBean;
import org.springframework.stereotype.Component;

@Component
public class UserClientServiceHystrix implements UserClientApi {

    @Override
    public Result userLogin(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result changePassWord(ChangePassWordBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result forbiddenUser(UserBean userBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }
}
