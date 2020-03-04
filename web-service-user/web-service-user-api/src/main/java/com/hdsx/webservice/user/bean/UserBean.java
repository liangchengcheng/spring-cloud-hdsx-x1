package com.hdsx.webservice.user.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日13:45:32
 * 用户表
 **/
@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserBean implements Serializable {
    @ApiModelProperty("用户的id")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户的状态，0 正常、 1禁用")
    private int state;
}
