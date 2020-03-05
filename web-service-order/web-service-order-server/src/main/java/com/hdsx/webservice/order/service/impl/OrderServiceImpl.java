package com.hdsx.webservice.order.service.impl;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.multimedia.api.ImageServiceApi;
import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import com.hdsx.webservice.order.bean.order.OrderBean;
import com.hdsx.webservice.order.bean.order.OrderQueryBean;
import com.hdsx.webservice.order.dao.OrderMapper;
import com.hdsx.webservice.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Result getOrderList(OrderQueryBean orderQueryBean) {
        try {
            if (orderQueryBean == null) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            Map<Object, Object> map = new HashMap<>();
            List<OrderBean> orderBeans = orderMapper.getOrderList(orderQueryBean);
            map.put("list",orderBeans);
            map.put("total", 0);

            if (orderBeans != null && orderBeans.size() > 0) {
                int total = orderMapper.getOrderListNum(orderQueryBean);
                map.put("total", total);
            }

            return ResultUtil.success(ResultCode.QUERY_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result addOrder(OrderBean orderBean) {
        try {
            if (orderBean == null) {
                return ResultUtil.success(ResultCode.ADD_FAIL);
            }

            int flag = orderMapper.addOrder(orderBean);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.ADD_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.success(ResultCode.ADD_FAIL);
    }

    @Override
    public Result editOrder(OrderBean orderBean) {
        try {
            if (orderBean == null) {
                return ResultUtil.error(ResultCode.ADD_FAIL);
            }

            int flag = orderMapper.editOrder(orderBean);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.ADD_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultCode.ADD_FAIL);
    }

    @Override
    public Result getOrderById(String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            OrderBean orderBean = orderMapper.getOrderById(id);
            return ResultUtil.success(ResultCode.QUERY_SUCCESS, orderBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }
}

