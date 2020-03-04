package com.hdsx.webservice.multimedia.bean.vedio;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class VedioBean implements Serializable {
    @ApiModelProperty("视频id")
    private String id;

    @ApiModelProperty("视频类型")
    private int type;

    @ApiModelProperty("外键id")
    private String mapperid;

    @ApiModelProperty("视频原始名称")
    private String vedioname;

    @ApiModelProperty("视频相对路径")
    private String vediourl;
}
