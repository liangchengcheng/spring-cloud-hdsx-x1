package com.hdsx.webservice.product.service;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.product.bean.ProductInfoBean;
import com.hdsx.webservice.product.bean.ProductNumBean;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日21:41:51
 * 商品的接口- JAVA
 */
public interface ProductService {

    Result InsertOrUpdateProduct(ProductInfoBean productInfoBean);

    Result getProductById(String id);

    Result UpdateProductNumBean(ProductNumBean productNumBean);

}
