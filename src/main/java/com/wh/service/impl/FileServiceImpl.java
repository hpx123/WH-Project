package com.wh.service.impl;

import com.google.common.collect.Lists;
import com.wh.common.ServerResponse;
import com.wh.dao.UserMapper;
import com.wh.pojo.User;
import com.wh.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by geely
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    @Autowired
    private UserMapper userMapper;

    //private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    //SpringMVc 封装的文件对象  MultipartFile
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        //logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            //赋予权限，让它可写，可以在webapp下可以写
            fileDir.setWritable(true);
            //mkdirs：所有级的 mkdir：当级的
            fileDir.mkdirs();
        }

        //目录创建好了创建文件
        File targetFile = new File(path, uploadFileName);


        try {
            //springMVC封装的file
            //用nginx做静态代理
            file.transferTo(targetFile);


            //targetFile.delete();
        } catch (IOException e) {
            //logger.error("上传文件异常",e);
            return null;
        }
        //A:abc.jpg
        //B:abc.jpg
        //String fileUrl = getUrl(targetFile.getName(),uploadFileName);
        int result = userMapper.uploadPhoto(targetFile.getName());
        if(result < 0){
            return "更新失败";
        }
        return targetFile.getName();
    }

    public String getUrl(String uri, String filename) {
        StringBuilder url = new StringBuilder();
        url.append("http://");
        url.append("116.62.179.174");
       url.append(":");
        url.append("80");
        url.append(uri);
        url.append("/");
        url.append(filename);
        return url.toString();
    }
}