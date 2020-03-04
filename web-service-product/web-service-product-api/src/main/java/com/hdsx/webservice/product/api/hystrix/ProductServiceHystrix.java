package com.hdsx.webservice.product.api.hystrix;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.product.api.ProductApi;
import com.hdsx.webservice.product.bean.ProductInfoBean;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceHystrix implements ProductApi {

    @Override
    public Result InsertOrUpdateProduct(ProductInfoBean productInfoBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getProductById(String id) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }
}
