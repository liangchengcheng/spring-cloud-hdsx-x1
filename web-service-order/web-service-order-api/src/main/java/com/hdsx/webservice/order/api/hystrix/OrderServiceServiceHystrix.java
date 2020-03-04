package com.hdsx.webservice.order.api.hystrix;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.order.api.OrderServicetApi;
import com.hdsx.webservice.order.bean.order.OrderBean;
import com.hdsx.webservice.order.bean.order.OrderQueryBean;
import org.springframework.stereotype.Component;

/**
 * 梁铖城
 * 2020年03月04日21:57:09
 * 推荐定义具体错误信息
 */
@Component
public class OrderServiceServiceHystrix implements OrderServicetApi {

    @Override
    public Result getOrderList(OrderQueryBean orderQueryBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result addOrder(OrderBean orderBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result editOrder(OrderBean orderBean) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getOrderById(String id) {
        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }
}
