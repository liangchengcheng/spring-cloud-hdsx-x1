package com.hdsx.webservice.multimedia.bean.file;

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
public class AddRequestFileBean implements Serializable {

    @ApiModelProperty("文件数据")
    private List<FileBean> files;

    @ApiModelProperty("外键id")
    private String mapperid;

    @ApiModelProperty("文件分类")
    private int filetype;
}

