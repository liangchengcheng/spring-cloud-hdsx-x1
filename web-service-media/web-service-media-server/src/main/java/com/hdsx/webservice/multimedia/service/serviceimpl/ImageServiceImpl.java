package com.hdsx.webservice.multimedia.service.serviceimpl;

import com.hdsx.webservice.multimedia.bean.image.AddRequestImageBean;
import com.hdsx.webservice.multimedia.bean.image.ImageBean;
import com.hdsx.webservice.multimedia.dao.ImageMapper;
import com.hdsx.webservice.multimedia.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ImageServiceImpl implements ImageService {
    @Value("${drinkwater.imagePath}")
    private String imagePath;

    @Value("${drinkwater.imageShowPath}")
    private String imageShowPath;

    private Path fileStoragePath;

    @Resource
    private ImageMapper imageMapper;

    @Override
    public List<ImageBean> getImageBeanByMapperId(String mapperid) {
        if (mapperid == null || mapperid.length() <= 0) {
            return null;
        }

        return imageMapper.searchImages(mapperid);
    }

    @Override
    public ImageBean getImageBeanById(String imageid) {
        if (imageid == null || imageid.length() <= 0) {
            return null;
        }

        return imageMapper.searchOneImage(imageid);
    }

    @Override
    public ImageBean uploadOneImage(MultipartFile multipartFile, int imagetype) {
        if (multipartFile == null) {
            return null;
        }
        return saveFile(multipartFile, imagetype);
    }

    @Override
    public List<ImageBean> uploadImages(MultipartFile[] images, int imagetype) {
        if (images == null || images.length <= 0) {
            return null;
        }

        List<ImageBean> fileBeans = new ArrayList<>();
        for (MultipartFile file : images) {
            ImageBean bean = saveFile(file, imagetype);
            fileBeans.add(bean);
        }

        if (fileBeans.size() <= 0) {
            return null;
        }

        return fileBeans;
    }

    @Override
    public Boolean insertOneImage(ImageBean imageBean) {
        int success = imageMapper.insertOneImage(imageBean);
        return success == 1;
    }

    @Override
    public Boolean deleteImagesByMapperId(String mapperid) {
        int success = imageMapper.deleteImagesByMapperId(mapperid);
        return success == 1;
    }

    @Override
    public Boolean insertImages(AddRequestImageBean addRequestImageBean) {
        if (addRequestImageBean == null) {
            return false;
        }

        List<ImageBean> images = addRequestImageBean.getImages();
        String mapperid = addRequestImageBean.getMapperid();
        if (mapperid == null || mapperid.length() <= 0) {
            return false;
        }

        // TODO: 2020/2/11 暂时不用type
        deleteImagesByMapperId(mapperid);

        if (images.size() <= 0) {
            return true;
        }

        for (ImageBean imageBean : images) {
            imageBean.setMapperid(mapperid);
        }
        int success = imageMapper.insertImagesBatch(images);
        return success == 1;
    }

    private ImageBean saveFile(MultipartFile file, int filetype) {
        String rename = null;
        try {
            fileStoragePath = Paths.get(imagePath).toAbsolutePath().normalize();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String type = fileName.substring(fileName.lastIndexOf("."));
            rename = UUID.randomUUID().toString()  + type;
            Path targetLocation = fileStoragePath.resolve(filetype + "/" + rename);
            File dest = new File(imagePath + "/" + filetype);
            // 判断文件父目录是否存在
            if (!dest.exists()) {
                dest.mkdirs();
            }
            // 采用transferTo
            file.transferTo(targetLocation.toFile());
            // Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        ImageBean bean = new ImageBean();
        bean.setImagename(file.getOriginalFilename());
        bean.setImageurl(imageShowPath + filetype + "/" + rename);
        bean.setType(filetype);
        return bean;
    }


}
