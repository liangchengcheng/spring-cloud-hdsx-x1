package com.hdsx.webservice.order.api;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.order.api.hystrix.OrderServiceServiceHystrix;
import com.hdsx.webservice.order.bean.order.OrderBean;
import com.hdsx.webservice.order.bean.order.OrderQueryBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "web-service-order-server",path = "/order",fallback = OrderServiceServiceHystrix.class)
public interface OrderServicetApi {

    /**
     * 获取订单列表
     */
    @ApiOperation(value = "获取订单列表", httpMethod = "POST", produces = "application/json", notes = "获取订单列表")
    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    Result getOrderList(@RequestBody OrderQueryBean orderQueryBean);

    /**
     * 新增订单信息
     */
    @ApiOperation(value = "新增订单信息", httpMethod = "POST", produces = "application/json", notes = "新增订单信息")
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    Result addOrder(@RequestBody OrderBean orderBean);

    /**
     * 编辑订单信息
     */
    @ApiOperation(value = "编辑订单信息", httpMethod = "POST", produces = "application/json", notes = "编辑订单信息")
    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    Result editOrder(@RequestBody OrderBean orderBean);

    @ApiOperation(value = "获取订单信息详情通过Id")
    @RequestMapping(value = "/getOrderById", method = RequestMethod.GET, produces = "application/json")
    Result getOrderById(@RequestParam String id);

}
