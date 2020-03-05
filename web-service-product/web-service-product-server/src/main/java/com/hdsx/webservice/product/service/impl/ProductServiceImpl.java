package com.hdsx.webservice.product.service.impl;

import com.hdsx.webservice.common.config.bean.Result;
import com.hdsx.webservice.common.config.bean.ResultCode;
import com.hdsx.webservice.common.config.bean.ResultUtil;
import com.hdsx.webservice.multimedia.api.ImageServiceApi;
import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import com.hdsx.webservice.product.bean.ProductBean;
import com.hdsx.webservice.product.bean.ProductInfoBean;
import com.hdsx.webservice.product.bean.ProductNumBean;
import com.hdsx.webservice.product.dao.ProductMapper;
import com.hdsx.webservice.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Autowired
    private ImageServiceApi imageApi;

    @Override
    public Result InsertOrUpdateProduct(ProductInfoBean productInfoBean) {
        try {
            if (productInfoBean == null || productInfoBean.getProductBean() == null) {
                return ResultUtil.error(ResultCode.UPDATE_FAIL);
            }
            // 获取基本信息
            ProductBean productBean = productInfoBean.getProductBean();
            // 获取基本信息的ID
            String id = productBean.getId();
            // 判断库里之前有没有,update或者insert
            ProductBean productById = productMapper.getProductById(id);
            if (productById != null) {
                productMapper.editProduct(productBean);
            } else {
                productMapper.addProduct(productBean);
            }

            // 获取图片信息
            List<ImageBean> imageBeans = productInfoBean.getImageBeans();
            AddRequestImageBean imageBean = new AddRequestImageBean();
            imageBean.setImages(imageBeans);
            // 删除图片、再插入图片（应该用分布式事物）
            imageApi.deleteImagesByMapperId(id);
            if(null != imageBeans && imageBeans.size() >0){
                imageBean.setMapperid(id);
                imageApi.insertImages(imageBean);
            }

            return ResultUtil.success(ResultCode.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultCode.UPDATE_FAIL);
    }

    @Override
    public Result getProductById(String id) {
        try {
            ProductBean product = productMapper.getProductById(id);
            if (product == null) {
                return ResultUtil.success(ResultCode.UPDATE_SUCCESS ,null);
            }

            ProductInfoBean productInfoBean = new ProductInfoBean();
            List<ImageBean> imageBeanByMapperId = imageApi.getImageBeanByMapperId(id);
            productInfoBean.setProductBean(product);
            productInfoBean.setImageBeans(imageBeanByMapperId);
            return ResultUtil.success(ResultCode.UPDATE_SUCCESS ,productInfoBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.QUERY_FAIL);
    }

    @Override
    public Result UpdateProductNumBean(ProductNumBean productNumBean) {
        try {
            if (productNumBean == null) {
                return ResultUtil.success(ResultCode.UPDATE_SUCCESS ,null);
            }

            int flag = productMapper.updateProductNumBean(productNumBean);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.UPDATE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.UPDATE_FAIL);
    }
}

