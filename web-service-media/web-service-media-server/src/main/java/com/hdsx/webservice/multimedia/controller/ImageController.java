package com.hdsx.webservice.multimedia.controller;

import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import com.hdsx.webservice.multimedia.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月12日10:39:18
 * 图片对外的服务
 */
@RestController
@RequestMapping(value = "/image")
@Slf4j
@Api(value = "图片服务",description = "图片服务")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mapperid", dataType = "String", required = true, value = "关联外键id")})
    @ApiOperation("根据外键id获取图片表单数据")
    @RequestMapping(value = "/getImageBeanByMapperId",method = RequestMethod.GET,produces = "application/json")
    public List<ImageBean> getImageBeanByMapperId(@RequestParam String mapperid) {
        return imageService.getImageBeanByMapperId(mapperid);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "imageid", dataType = "String", required = true, value = "图片id")})
    @ApiOperation("根据图片id获取图片表单数据")
    @RequestMapping(value = "/getImageBeanById",method = RequestMethod.GET,produces = "application/json")
    public ImageBean getImageBeanById(@RequestParam String imageid) {
        return imageService.getImageBeanById(imageid);
    }

    @ApiOperation(value = "多图片上传接口", notes = "多图片上传接口")
    @RequestMapping(value = "/uploadImages", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    public List<ImageBean> uploadImages(@RequestParam MultipartFile[] images, @RequestParam int imagetype) {
        return imageService.uploadImages(images, imagetype);
    }

    @ApiOperation(value = "单图片上传接口", notes = "单图片上传接口")
    @RequestMapping(value = "/uploadOneImage", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    public ImageBean uploadOneImage(@RequestParam MultipartFile image, @RequestParam int imagetype) {
        return imageService.uploadOneImage(image, imagetype);
    }

    @ApiOperation("新增一条图片表单数据")
    @RequestMapping(value = "/insertOneImage",method = RequestMethod.POST, produces = "application/json")
    public Boolean insertOneImage(@RequestBody ImageBean imageBean) {
        return imageService.insertOneImage(imageBean);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mapperid", dataType = "String", required = true, value = "关联外键id")})
    @ApiOperation("删除外键id关联的图片表单数据")
    @RequestMapping(value = "/deleteImagesByMapperId",method = RequestMethod.DELETE)
    public Boolean deleteImagesByMapperId(@RequestParam("mapperid") String mapperid) {
        return imageService.deleteImagesByMapperId(mapperid);
    }

    @ApiOperation("新增多条图片表单数据")
    @RequestMapping(value = "/insertImages",method = RequestMethod.POST, produces = "application/json")
    public Boolean insertImages(@RequestBody AddRequestImageBean bean) {
        if (bean == null) {
            return false;
        }

        return imageService.insertImages(bean);
    }

}
