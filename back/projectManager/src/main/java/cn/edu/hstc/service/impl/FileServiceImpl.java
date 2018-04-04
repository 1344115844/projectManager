package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.FilepathMapper;
import cn.edu.hstc.pojo.Filepath;
import cn.edu.hstc.service.FileService;

import cn.edu.hstc.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    FilepathMapper filepathMapper;
    private Logger logger = LoggerFactory.getLogger(getClass());
    // 文件类型
    private static Map<String, String> fileTypes = new HashMap<>();
    private static final long maxFileSize = 10 * 1024 * 1024;//文件最大10M

    static {
        fileTypes.put("image", ".jpg");
        fileTypes.put("document", ".pdf");
    }

    /**
    * @Description:上传文件，返回文件的url
    * @param: [file, path]
    * @return: cn.edu.hstc.common.JSONResponse<java.lang.String>
    * @author: yifang
    * @Date: 2018/4/3 10:12
    */
    public JSONResponse<String> upload(MultipartFile file, String path) {
//        if(file!=null) {
            //检查文件是否为空
            if (file.getSize() == 0)
                return JSONResponse.createByErrorMessage("附件为空");
            //检查文件大小
            if (file.getSize() > maxFileSize)
                return JSONResponse.createByErrorMessage("上传文件不能超过10M");
            //检查文件扩展名
            String fileName = file.getOriginalFilename();
            String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
            if (!fileTypes.containsValue(fileExtensionName))
                return JSONResponse.createByErrorMessage("文件格式错误");

            String uploadFileName = UUID.randomUUID().toString() + fileExtensionName;
            logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);

            //若文件目录不存在，新建，例如path为/uploads/zyf/academic/
            File fileDir = new File(path);
            if (!fileDir.exists()) {
                fileDir.setWritable(true);
                fileDir.mkdirs();
            }
            File targetFile = new File(path, uploadFileName);
            String url = path + uploadFileName;//文件完整路径
            try {
                file.transferTo(targetFile);
                //文件已经上传成功了
            } catch (IOException e) {
                logger.error("上传文件异常", e);
                return JSONResponse.createByErrorMessage("上传文件异常");
            }

            return JSONResponse.createBySuccess(url);
//        }else{
//        return JSONResponse.createByErrorMessage("附件为空");
//        }
    }

    /**
    * @Description:保存附件url，userId等信息到filepath表中，并返回fileId
    * @param: [url, userId]
    * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
    * @author: yifang
    * @Date: 2018/4/3 10:14
    */
    @Override
    public JSONResponse<Integer> updateFilepathInfo(String url, Integer userId) {
        Filepath fp = new Filepath(DateTimeUtil.getDate(), url, userId);
        int rs = filepathMapper.insertSelective(fp);
        //将url添加到filepath表成功，则由url找到并返回fileId
        if (rs == 1)
            return JSONResponse.createBySuccess(filepathMapper.getFileIdByUrl(url));
        else
            return JSONResponse.createByErrorMessage("文件保存失败");
    }

}
