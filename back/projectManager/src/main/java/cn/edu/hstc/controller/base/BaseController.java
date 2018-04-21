package cn.edu.hstc.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/4/17 19:27
 */
@Controller

public class BaseController {



/**
 *@author Veng Su 2018/4/17 20:43
 *方法作用：根据filepath下载文件
 **/
    @RequestMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String filepath) throws Exception{
        //获取服务文件真实地址
        String realFilepath=request.getSession().getServletContext().getRealPath("/");
        //替换"/"为"\"
        filepath=filepath.replace("/","\\");
        //拼接文件真实地址
        String fileName = realFilepath+filepath;
        //获取输入流
        InputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        } catch (FileNotFoundException e) {
            throw e;
        }
        //获取文件扩展名
        String append=fileName.substring(fileName.lastIndexOf(".")+1);
        //假如以中文名下载的话
        String filename = "证明附件."+append;
        //转码，免得文件名中文乱码
        try {
            filename = URLEncoder.encode(filename,"UTF-8");
        } catch (UnsupportedEncodingException e) {
//            return JSONResponse.createByErrorMessage("转码失败");
            throw e;
        }
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(response.getOutputStream());
        } catch (IOException e) {
            throw e;
        }
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();

    }
}
