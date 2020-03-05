package com.hdsx.webservice.product.dao;

import com.hdsx.webservice.product.bean.ProductBean;
import com.hdsx.webservice.product.bean.ProductNumBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    /**
     * 添加商品信息
     */
    int addProduct(ProductBean productBean);

    /**
     * 修改商品信息
     */
    int editProduct(ProductBean productBean);

    /**
     * 通过ID获取商品信息
     */
    ProductBean getProductById(String id);

    /**
     * 修改商品信息
     */
    int updateProductNumBean(ProductNumBean productNumBean);

}
