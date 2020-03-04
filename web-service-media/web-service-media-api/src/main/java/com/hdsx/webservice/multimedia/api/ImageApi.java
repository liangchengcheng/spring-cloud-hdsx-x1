package com.hdsx.webservice.multimedia.api;

import com.hdsx.webservice.multimedia.api.hystrix.ImageServiceHystrix;
import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "drink-water-multimedia",path="/image",fallback = ImageServiceHystrix.class)
public interface ImageApi {

    @ApiOperation(value = "单图片上传接口", notes = "单图片上传接口")
    @RequestMapping(value = "/uploadOneImage", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    ImageBean uploadOneImage(@RequestParam MultipartFile image, @RequestParam int imagetype);

    @ApiOperation(value = "多图片上传接口", notes = "多图片上传接口")
    @RequestMapping(value = "/uploadImages", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    List<ImageBean> uploadImages(@RequestParam MultipartFile[] images, @RequestParam int imagetype);

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mapperid", dataType = "String", required = true, value = "关联外键id")})
    @ApiOperation("根据外键id获取图片表单数据")
    @RequestMapping(value = "/getImageBeanByMapperId",method = RequestMethod.GET,produces = "application/json")
    List<ImageBean> getImageBeanByMapperId(@RequestParam String mapperid);

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "imageid", dataType = "String", required = true, value = "图片id")})
    @ApiOperation("根据图片id获取图片表单数据")
    @RequestMapping(value = "/getImageBeanById",method = RequestMethod.GET,produces = "application/json")
    ImageBean getImageBeanById(@RequestParam String imageid);

    @ApiOperation("新增多条图片表单数据")
    @RequestMapping(value = "/insertImages",method = RequestMethod.POST, produces = "application/json")
    Boolean insertImages(@RequestBody AddRequestImageBean bean);

    @ApiOperation("新增一条图片表单数据")
    @RequestMapping(value = "/insertOneImage",method = RequestMethod.POST, produces = "application/json")
    Boolean insertOneImage(@RequestBody ImageBean imageBean);

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mapperid", dataType = "String", required = true, value = "关联外键id")})
    @ApiOperation("删除外键id关联的图片表单数据")
    @RequestMapping(value = "/deleteImagesByMapperId",method = RequestMethod.DELETE)
    Boolean deleteImagesByMapperId(@RequestParam String mapperid);

}
