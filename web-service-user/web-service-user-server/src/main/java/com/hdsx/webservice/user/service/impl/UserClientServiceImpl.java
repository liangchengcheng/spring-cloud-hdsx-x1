package com.hdsx.webservice.user.service.impl;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.user.bean.ChangePassWordBean;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.dao.UserMapper;
import com.hdsx.webservice.user.service.UserClientService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日15:57:21
 * 登录、修改密码
 **/
@Service
@Transactional
public class UserClientServiceImpl implements UserClientService {

    @Resource
    UserMapper userMapper;

    @Override
    public Result userLogin(UserBean userBean) {
        try {
            if (userBean == null || StringUtils.isEmpty(userBean.getUsername()) || StringUtils.isEmpty(userBean.getPassword())) {
                return ResultUtil.error(ResultCode.PARAMETER_NOT_EXIST);
            }

            /**
             * 只做简单校验、密码也没md5、正式项目不可如此，
             * 这里返回的是用户基本信息，正式项目返回基本信息 + token
             */
            String username = userBean.getUsername();
            String pwd0 = userBean.getPassword();
            UserBean userByName = userMapper.getUserByName(username);

            // 校验用户是否存在
            if (userByName == null) {
                return ResultUtil.error(ResultCode.AUTH_PARAMETER_ERROR);
            }

            // 校验用户是否被禁用
            if (userByName.getState() == 1) {
                return ResultUtil.error(ResultCode.USER_FORBIDDEN);
            }

            // 校验密码是否正确
            String pwd1 = userByName.getPassword();
            if (!pwd0.equals(pwd1)) {
                return ResultUtil.error(ResultCode.PASSWORD_ERROR);
            }

            // 返回用户基本信息
            return ResultUtil.success(ResultCode.LOGIN_SUCCESS, userByName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.LOGIN_FAIL);
    }

    @Override
    public Result changePassWord(ChangePassWordBean userBean) {
       try {
           if (userBean == null || StringUtils.isEmpty(userBean.getUsername()) || StringUtils.isEmpty(userBean.getPassword())
                   || StringUtils.isEmpty(userBean.getKey())) {
               return ResultUtil.error(ResultCode.PARAMETER_NOT_EXIST);
           }

           /**
            * 只做简单校验、密码也没md5、正式项目不可如此，
            * 这里返回的是用户基本信息，正式项目返回基本信息 + token
            */
           String username = userBean.getUsername();
           String pwd0 = userBean.getPassword();
           UserBean userByName = userMapper.getUserByName(username);

           // 校验用户是否存在
           if (userByName == null) {
               return ResultUtil.error(ResultCode.AUTH_PARAMETER_ERROR);
           }

           // 校验用户是否被禁用
           if (userByName.getState() == 1) {
               return ResultUtil.error(ResultCode.USER_FORBIDDEN);
           }

           // 校验密码是否正确
           String pwd1 = userByName.getPassword();
           if (!pwd0.equals(pwd1)) {
               return ResultUtil.error(ResultCode.PASSWORD_ERROR);
           }

           // 校验KEY
           String key = userBean.getKey();
           int flag = userMapper.changePassWord(userBean);
           if (flag == 1) {
               // 返回用户基本信息
               return ResultUtil.success(ResultCode.ADD_SUCCESS, userByName);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return ResultUtil.error(ResultCode.MODIFY_FAIL);
    }

    /**
     * 未实现相关逻辑
     */
    @Override
    public Result forbiddenUser(UserBean userBean) {
        return null;
    }
}
