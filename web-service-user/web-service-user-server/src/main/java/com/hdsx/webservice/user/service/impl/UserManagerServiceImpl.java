package com.hdsx.webservice.user.service.impl;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.bean.UserQueryBean;
import com.hdsx.webservice.user.dao.UserMapper;
import com.hdsx.webservice.user.service.UserManagerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日15:19:36
 * 用户管理类的实现
 **/
@Service
@Transactional
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result addUser(UserBean userBean) {
      try {
          if (userBean == null) {
              return ResultUtil.success(ResultCode.ADD_FAIL);
          }

          int flag = userMapper.addUser(userBean);
          if (flag == 1) {
              return ResultUtil.success(ResultCode.ADD_SUCCESS);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }

      return ResultUtil.success(ResultCode.ADD_FAIL);
    }

    @Override
    public Result editUser(UserBean userBean) {
        try {
            if (userBean == null) {
                return ResultUtil.error(ResultCode.ADD_FAIL);
            }

            int flag = userMapper.editUser(userBean);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.ADD_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultCode.ADD_FAIL);

    }

    @Override
    public Result deleteUserByUserId(String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            int flag = userMapper.deleteUserByUserId(id);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.DELETE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.DELETE_FAIL);
    }

    @Override
    public Result getUserByName(String username) {
        try {
            if (StringUtils.isEmpty(username)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            UserBean userById = userMapper.getUserByName(username);
            return ResultUtil.success(ResultCode.QUERY_SUCCESS, userById);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserById(String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            UserBean userById = userMapper.getUserById(id);
            return ResultUtil.success(ResultCode.QUERY_SUCCESS, userById);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserList(UserQueryBean userQueryBean) {
        try {
            if (userQueryBean == null) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            Map<Object, Object> map = new HashMap<>();
            List<UserBean> userList = userMapper.getUserList(userQueryBean);
            map.put("data",userList);
            map.put("total", 0);

            if (userList != null && userList.size() > 0) {
                int total = userMapper.getUserListCount(userQueryBean);
                map.put("total", total);
            }

            return ResultUtil.success(ResultCode.QUERY_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }
}
