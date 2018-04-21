package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Study;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.StudyService;
import cn.edu.hstc.service.FileService;
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
 * @description:进修学习
 * @modified by:
 */

@Controller
@RequestMapping("/study")
public class StudyController {
    @Autowired
    StudyService studyService;

    @Autowired
    FileService fileService;

    /**
     * @Description:添加进修学习
     * @param: [session, study]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
     * @author: yifang
     * @Date: 2018/4/1 9:48
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public JSONResponse addStudy(HttpSession session, Study stu) {
        User user = (User) session.getAttribute("currentUser");
        stu.setUserId(user.getUserId());
        return studyService.addStudy(stu);
    }


    /**
     * @Description:删除进修学习
     * @param: [session, stu_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
     * @author: yifang
     * @Date: 2018/4/1 9:52
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public JSONResponse<Integer> deleteStudy(Integer stuId) {
        return studyService.deleteStudy(stuId);
    }

    /**
     * @Description:修改进修学习
     * @param: [session, study]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
     * @author: yifang
     * @Date: 2018/4/1 9:58
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public JSONResponse updateStudy(HttpSession session, Study stu) {
        User user = (User) session.getAttribute("currentUser");
        stu.setUserId(user.getUserId());
        return studyService.updateStudy(stu);
    }

    /**
     * @Description:按ID查询
     * @param: [session, stu_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
     * @author: yifang
     * @Date: 2018/4/1 10:00
     */
    @RequestMapping("/selectById.do")
    @ResponseBody
    public JSONResponse<Study> selectStudyById(Integer stuId) {
        return studyService.selectStudyById(stuId);
    }

    /**
     * @Description:返回用户拥有的进修学习列表
     * @param: [session]
     * @return:
     * @author: yifang
     * @Date: 2018/4/1 10:02
     */
    @RequestMapping("/selectByUserId.do")
    @ResponseBody
    public JSONResponse selectStudyListByUserId(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        User user = (User) session.getAttribute("currentUser");
        return studyService.selectStudyListByUserId(user.getUserId(), pageNum, pageSize);
    }


    /**
     * @Description:查询进修学习数目
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
     * @author: yifang
     * @Date: 2018/4/1 10:28
     */
    @RequestMapping("/getCount.do")
    @ResponseBody
    public JSONResponse<Integer> getStudyCountByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return JSONResponse.createBySuccess(0);
        return studyService.getStudyCountByUserId(user.getUserId());
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 0:01
     * 方法作用：跳转到list
     **/
    @RequestMapping("/list")
    public String showStudyList() {
        return "/study/list";
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 20:30
     * 方法作用：跳转到add页面
     **/
    @RequestMapping("/add")
    public String showStudyAdd() {
        return "/study/add";
    }


    @RequestMapping("/edit")
    public String showStudyEdit() {
        return "/study/edit";
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
        String path = request.getSession().getServletContext().getRealPath("uploads") + "\\" + username + "\\study\\";
//        path = path.substring(0, path.indexOf("target")) + "src\\main\\webapp\\" + path.substring(path.indexOf("uploads"));
        JSONResponse<String> upd = fileService.upload(file, path);
        if (!upd.isSuccess())//若上传出错
            return upd;

        String url ="/uploads"+"/"+username+"/study"+"/"+ upd.getData();

        //上传成功，保存url到filepath表，并返回fileId
        return fileService.updateFilepathInfo(url, userId);


    }


}