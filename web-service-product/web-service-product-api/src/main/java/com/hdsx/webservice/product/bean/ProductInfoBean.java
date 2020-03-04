package com.hdsx.webservice.product.bean;

import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ProductInfoBean implements Serializable {

    @ApiModelProperty("商品基本信息")
    private ProductBean productBean;

    @ApiModelProperty("商品图片集合")
    private List<ImageBean> imageBeans;

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public List<ImageBean> getImageBeans() {
        return imageBeans;
    }

    public void setImageBeans(List<ImageBean> imageBeans) {
        this.imageBeans = imageBeans;
    }
}
