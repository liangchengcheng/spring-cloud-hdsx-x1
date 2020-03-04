package com.hdsx.webservice.user.dao;

import com.hdsx.webservice.user.bean.ChangePassWordBean;
import com.hdsx.webservice.user.bean.UserBean;
import com.hdsx.webservice.user.bean.UserQueryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日15:13:27
 * 用户的数据库操作类
 **/
@Mapper
public interface UserMapper {

    /**
     * 新增用户
     */
    int addUser(UserBean userBean);

    /**
     * 编辑用户
     */
    int editUser(UserBean userBean);

    /**
     * 根据用户ID删除用户
     */
    int deleteUserByUserId(String id);

    /**
     * 根据用户名查询用户
     */
    UserBean getUserByName(String username);

    /**
     * 根据ID查询用户
     */
    UserBean getUserById(String id);

    /**
     * 查询用户
     */
    List<UserBean> getUserList(UserQueryBean userQueryBean);

    /**
     * 查询多少个数据 - 分页用
     */
    int getUserListCount(UserQueryBean userQueryBean);

    /**
     * 修改用户的密码
     */
    int changePassWord(ChangePassWordBean changePassWordBean);

}
