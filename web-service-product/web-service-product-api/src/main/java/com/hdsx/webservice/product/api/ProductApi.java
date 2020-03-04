package com.hdsx.webservice.product.api;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.product.api.hystrix.ProductServiceHystrix;
import com.hdsx.webservice.product.bean.ProductInfoBean;
import com.hdsx.webservice.product.bean.ProductNumBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "web-service-product-server",path = "/prodcutservice",fallback = ProductServiceHystrix.class)
public interface ProductApi {

    /**
     * 商品基本信息 + 商品图片信息
     */
    @ApiOperation(value = "新增或更新商品", httpMethod = "POST", produces = "application/json", notes = "新增或更新商品")
    @RequestMapping(value = "/InsertOrUpdateProduct", method = RequestMethod.POST)
    Result InsertOrUpdateProduct(@RequestBody ProductInfoBean productInfoBean);

    @ApiOperation(value = "获取商品信息详情通过Id")
    @RequestMapping(value = "/getProductById", method = RequestMethod.GET, produces = "application/json")
    Result getProductById(@RequestParam String id);

    @ApiOperation(value = "更新商品的库存", httpMethod = "POST", produces = "application/json", notes = "更新商品的库存")
    @RequestMapping(value = "/UpdateProductNumBean", method = RequestMethod.POST)
    Result UpdateProductNumBean(@RequestBody ProductNumBean productNumBean);



}
