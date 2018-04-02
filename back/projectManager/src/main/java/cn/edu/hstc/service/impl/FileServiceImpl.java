package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.service.FileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
* @Description:文件上传服务
* @author: yifang
* @Date: 2018/4/2 19:16
*/
@Service
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    // 文件类型
    private static Map<String,String> fileTypes = new HashMap<>();

    static {
        fileTypes.put("image",".jpg");
        fileTypes.put("document",".pdf");
    }

    //返回上传文件的url
    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        //检查文件扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
        if(!fileTypes.containsValue(fileExtensionName))return null;

        String uploadFileName = UUID.randomUUID().toString()+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        //若文件目录不存在，新建
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
            //文件已经上传成功了
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }

        return path+uploadFileName;
    }

}
