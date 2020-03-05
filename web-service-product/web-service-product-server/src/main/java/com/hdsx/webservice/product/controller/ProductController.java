package com.hdsx.webservice.product.controller;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.product.bean.ProductInfoBean;
import com.hdsx.webservice.product.bean.ProductNumBean;
import com.hdsx.webservice.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日22:48:32
 * 商品信息对外接口
 */
@RestController
@RequestMapping("/product")
@Slf4j
@Api(value = "商品信息对外接口服务", description = "商品信息对外接口服务")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "新增或更新商品信息", httpMethod = "POST", produces = "application/json", notes = "新增或更新商品信息")
    @RequestMapping(value = "/InsertOrUpdateProduct", method = RequestMethod.POST)
    public Result InsertOrUpdateProduct(@RequestBody ProductInfoBean productInfoBean) {
        try {
            return productService.InsertOrUpdateProduct(productInfoBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.UPDATE_FAIL);
        }
    }

    @ApiImplicitParam(paramType = "query", name = "id", dataType = "String", required = true, value = "商品id")
    @ApiOperation(value = "通过ID查询商品详情", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getProductById",method = RequestMethod.GET,produces = "application/json")
    public Result getProductById(@RequestParam String id){
        try{
            return productService.getProductById(id);
        } catch (Exception e){
            log.error("服务器异常{}",e.getMessage(),e);
            return ResultUtil.error(ResultCode.QUERY_FAIL);
        }
    }

    @ApiOperation(value = "减少商品库存", httpMethod = "POST", produces = "application/json", notes = "减少商品库存")
    @RequestMapping(value = "/UpdateProductNumBean", method = RequestMethod.POST)
    public Result UpdateProductNumBean(@RequestBody ProductNumBean productNumBean) {
        try {
            return productService.UpdateProductNumBean(productNumBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.UPDATE_FAIL);
        }
    }

}
