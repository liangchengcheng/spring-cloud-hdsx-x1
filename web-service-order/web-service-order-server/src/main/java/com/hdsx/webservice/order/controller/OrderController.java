package com.hdsx.webservice.order.controller;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.order.bean.order.OrderBean;
import com.hdsx.webservice.order.bean.order.OrderQueryBean;
import com.hdsx.webservice.order.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日16:22:11
 * 订单管理服务
 **/
@RestController
@RequestMapping(value = "/order")
@Slf4j
@ApiModel(description = "订单管理服务")
public class OrderController {

    @Resource
    OrderService orderService;

    @ApiOperation(value = "获取订单列表", httpMethod = "POST", produces = "application/json", notes = "获取订单列表")
    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST, produces = "application/json")
    public Result getOrderList(@RequestBody OrderQueryBean orderQueryBean) {
        try {
            return orderService.getOrderList(orderQueryBean);
        } catch (Exception e) {
            log.error("系统异常获取订单列表:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.LOGIN_FAIL);
        }
    }

    @ApiOperation(value = "新增订单信息", httpMethod = "POST", produces = "application/json", notes = "新增订单信息")
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = "application/json")
    public Result addOrder(@RequestBody OrderBean orderBean) {
        try {
            return orderService.addOrder(orderBean);
        } catch (Exception e) {
            log.error("新增订单信息系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.ADD_FAIL);
        }
    }

    @ApiOperation(value = "编辑订单信息", httpMethod = "POST", produces = "application/json", notes = "编辑订单信息")
    @RequestMapping(value = "/editOrder", method = RequestMethod.POST, produces = "application/json")
    public Result editOrder(@RequestBody OrderBean orderBean) {
        try {
            return orderService.editOrder(orderBean);
        } catch (Exception e) {
            log.error("编辑订单信息系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.ADD_FAIL);
        }
    }

    @ApiImplicitParam(paramType = "query", name = "id", dataType = "String", required = true, value = "订单ID")
    @ApiOperation(value = "根据ID查询订单", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getOrderById",method = RequestMethod.GET,produces = "application/json")
    public Result getOrderById(@RequestParam String id){
        try{
            return orderService.getOrderById(id);
        } catch (Exception e){
            log.error("根据ID查询订单服务器异常{}",e.getMessage(),e);
            return ResultUtil.error(ResultCode.QUERY_FAIL);
        }
    }

}
