package com.hdsx.webservice.order.service;

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

/**
 * 梁铖城
 * 2020年03月05日08:04:02
 * 订单接口
 */
public interface OrderService {

    Result getOrderList(OrderQueryBean orderQueryBean);

    Result addOrder(OrderBean orderBean);

    Result editOrder(OrderBean orderBean);

    Result getOrderById(String id);
}
