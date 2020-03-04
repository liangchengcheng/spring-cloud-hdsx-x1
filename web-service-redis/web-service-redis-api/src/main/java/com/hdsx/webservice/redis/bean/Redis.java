package com.hdsx.webservice.redis.bean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日10:58:57
 * redis操作的对象
 */
@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Redis implements Serializable {

    @ApiModelProperty("键")
    private String key;

    @ApiModelProperty("保存的数据对象")
    private Object value;

    @ApiModelProperty("过期时间：单位为秒")
    private Integer seconds;
}
