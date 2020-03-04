package com.hdsx.webservice.multimedia.bean.file;

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
public class FileBean implements Serializable {

    @ApiModelProperty("文件id")
    private String id;

    @ApiModelProperty("文件类型")
    private int type;

    @ApiModelProperty("外键id")
    private String mapperid;

    @ApiModelProperty("文件原始名称")
    private String filename;

    @ApiModelProperty("文件相对路径")
    private String fileurl;
}
