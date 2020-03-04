package com.hdsx.webservice.multimedia.bean.image;

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
public class ImageBean implements Serializable {

    @ApiModelProperty("图片id")
    private String id;

    @ApiModelProperty("图片类型")
    private int type;

    @ApiModelProperty("外键id")
    private String mapperid;

    @ApiModelProperty("图片原始名称")
    private String imagename;

    @ApiModelProperty("图片相对路径")
    private String imageurl;
}
