package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Academic;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.AcademicService;
import cn.edu.hstc.service.FileService;
import cn.edu.hstc.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yifang 1307720869@qq.com
 * @date Created in 9:43 2018/4/1
 * @description:学术论文
 * @modified by:
 */

@Controller
@RequestMapping("/academic")
public class AcademicController {
    @Autowired
    AcademicService academicService;

    @Autowired
    FileService fileService;

    /**
     * @Description:添加学术论文
     * @param: [session, acad]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
     * @author: yifang
     * @Date: 2018/4/1 9:48
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public JSONResponse addAcademic(HttpSession session, Academic acad) {
        User user = (User) session.getAttribute("currentUser");
        acad.setUserId(user.getUserId());
        return academicService.addAcademic(acad);
    }


    /**
     * @Description:删除学术论文
     * @param: [session, acad_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
     * @author: yifang
     * @Date: 2018/4/1 9:52
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public JSONResponse<Integer> deleteAcademic(Integer acadId) {
        return academicService.deleteAcademic(acadId);
    }

    /**
     * @Description:修改学术论文
     * @param: [session, acad]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
     * @author: yifang
     * @Date: 2018/4/1 9:58
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public JSONResponse updateAcademic(HttpSession session, Academic acad) {
        User user = (User) session.getAttribute("currentUser");
        acad.setUserId(user.getUserId());
        return academicService.updateAcademic(acad);
    }

    /**
     * @Description:按ID查询
     * @param: [session, acad_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
     * @author: yifang
     * @Date: 2018/4/1 10:00
     */
    @RequestMapping("/selectById.do")
    @ResponseBody
    public JSONResponse<Academic> selectAcademicById(Integer acadId) {
        return academicService.selectAcademicById(acadId);
    }

    /**
     * @Description:返回用户拥有的学术论文列表
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.vo.AcademicListVo>
     * @author: yifang
     * @Date: 2018/4/1 10:02
     */
    @RequestMapping("/selectByUserId.do")
    @ResponseBody
    public JSONResponse selectAcademicListByUserId(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        User user = (User) session.getAttribute("currentUser");
        return academicService.selectAcademicListByUserId(user.getUserId(), pageNum, pageSize);
    }


    /**
     * @Description:查询学术论文数目
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
     * @author: yifang
     * @Date: 2018/4/1 10:28
     */
    @RequestMapping("/getCount.do")
    @ResponseBody
    public JSONResponse<Integer> getAcademicCountByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return JSONResponse.createBySuccess(0);
        return academicService.getAcademicCountByUserId(user.getUserId());
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 0:01
     * 方法作用：跳转到list
     **/
    @RequestMapping("/list")
    public String showAcademicList() {
        return "/academic/list";
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 20:30
     * 方法作用：跳转到add页面
     **/
    @RequestMapping("/add")
    public String showAcademicAdd() {
        return "/academic/add";
    }

    /**
     *@author Veng Su
     *@date 2018/4/4 8:36
     *方法作用：跳转到edit页面
     **/
    @RequestMapping("/edit")
    public String showAcademicEdit() {
        return "/academic/edit";
    }


    /**
    * @Description:上传附件
    * @param: [session, file, request]
    * @return: cn.edu.hstc.common.JSONResponse
    * @author: yifang
    * @Date: 2018/4/3 10:07
    */
    @RequestMapping(value = "/uploadAttachment.do")
    @ResponseBody
    public JSONResponse uploadAttachment(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {
        User user = (User) session.getAttribute("currentUser");
        String username = user.getUsername();
        Integer userId = user.getUserId();
        String path = request.getSession().getServletContext().getRealPath("uploads")  + "\\"+username  + "\\academic\\";
//        path=path.substring(0,path.indexOf("target"))+"src\\main\\webapp\\"+path.substring(path.indexOf("uploads"));
        JSONResponse<String> upd = fileService.upload(file, path);
        if (!upd.isSuccess())//若上传出错
            return upd;

        String url ="/uploads"+"/"+username+"/academic"+"/"+ upd.getData();
        //上传成功，保存url到filepath表，并返回fileId
       return fileService.updateFilepathInfo(url, userId);
    }




}