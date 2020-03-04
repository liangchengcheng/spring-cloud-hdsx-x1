package com.hdsx.webservice.multimedia.bean.image;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class AddRequestImageBean implements Serializable {

    @ApiModelProperty("图片数据")
    private List<ImageBean> images;

    @ApiModelProperty("外键id")
    private String mapperid;

    @ApiModelProperty("图片类别")
    private int imagetype;
}
