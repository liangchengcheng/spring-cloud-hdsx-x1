package com.hdsx.webservice.multimedia.service;

import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ImageService {

    ImageBean uploadOneImage(MultipartFile multipartFile, int imagetype);

    List<ImageBean> uploadImages(MultipartFile[] images, int imagetype);

    List<ImageBean> getImageBeanByMapperId(String mapperid);

    ImageBean getImageBeanById(String imageid);

    Boolean insertImages(AddRequestImageBean bean);

    Boolean insertOneImage(ImageBean imageBean);

    Boolean deleteImagesByMapperId(String mapperid);

}
