package com.hdsx.webservice.user.service;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.user.bean.ChangePassWordBean;
import com.hdsx.webservice.user.bean.UserBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日14:59:27
 * 用户登录服务 - JAVA接口
 **/
public interface UserClientService {

    Result userLogin(UserBean userBean);

    Result changePassWord(ChangePassWordBean changePassWordBean);

    /**
     * 去掉、应该放在管理模块
     */
    Result forbiddenUser(UserBean userBean);
}
