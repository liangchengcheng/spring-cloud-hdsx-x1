package com.hdsx.webservice.multimedia.api.hystrix;

import com.hdsx.webservice.multimedia.api.ImageApi;
import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Component
public class ImageServiceHystrix implements ImageApi {

    @Override
    public List<ImageBean> uploadImages(MultipartFile[] images, int imagetype) {
        return null;
    }

    @Override
    public List<ImageBean> getImageBeanByMapperId(String mapperid) {
        return null;
    }

    @Override
    public ImageBean getImageBeanById(String imageid) {
        return null;
    }

    @Override
    public ImageBean uploadOneImage(MultipartFile image, int imagetype) {
        return null;
    }

    @Override
    public Boolean insertImages(AddRequestImageBean bean) {
        return null;
    }

    @Override
    public Boolean insertOneImage(ImageBean imageBean) {
        return null;
    }

    @Override
    public Boolean deleteImagesByMapperId(String mapperid) {
        return null;
    }


}
