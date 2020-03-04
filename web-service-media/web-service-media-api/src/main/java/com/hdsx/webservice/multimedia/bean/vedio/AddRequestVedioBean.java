package com.hdsx.webservice.multimedia.bean.vedio;

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
public class AddRequestVedioBean implements Serializable {

    @ApiModelProperty("视频数据")
    private List<VedioBean> vedios;

    @ApiModelProperty("外键id")
    private String mapperid;

    @ApiModelProperty("视频类别")
    private int vediotype;
}
