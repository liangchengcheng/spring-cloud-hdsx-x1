package com.hdsx.webservice.multimedia.dao;

import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImageMapper {

    List<ImageBean> searchImages(String mapperid);

    ImageBean searchOneImage(String imageid);

    int insertOneImage(ImageBean imageBean);

    int insertImagesBatch(List<ImageBean> imageBeans);

    int deleteImagesByMapperId(String mapperid);

}
