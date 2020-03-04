package com.hdsx.webservice.user.service;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.bean.UserQueryBean;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日15:02:44
 * 用户表的基本操作的 - JAVA 接口
 **/
public interface UserManagerService {

    Result addUser(UserBean userBean);

    Result editUser(UserBean userBean);

    Result deleteUserByUserId(String id);

    Result getUserByName(String username);

    Result getUserById(String id);

    Result getUserList(UserQueryBean userQueryBean);

}
