package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.AttendConference;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.AttendConferenceService;
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
 * @description:参加学术会议
 * @modified by:
 */

@Controller
@RequestMapping("/attendconference")
public class AttendConferenceController {
    @Autowired
    AttendConferenceService attendConferenceMapper;

    @Autowired
    FileService fileService;

    /**
     * @Description:添加参加学术会议
     * @param: [session, conf]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
     * @author: yifang
     * @Date: 2018/4/1 9:48
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public JSONResponse addAttendConference(HttpSession session, AttendConference conf) {
        User user = (User) session.getAttribute("currentUser");
        conf.setUserId(user.getUserId());
        return attendConferenceMapper.addAttendConference(conf);
    }


    /**
     * @Description:删除参加学术会议
     * @param: [session, conf_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
     * @author: yifang
     * @Date: 2018/4/1 9:52
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public JSONResponse<Integer> deleteAttendConference(Integer confId) {
        return attendConferenceMapper.deleteAttendConference(confId);
    }

    /**
     * @Description:修改参加学术会议
     * @param: [session, conf]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
     * @author: yifang
     * @Date: 2018/4/1 9:58
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public JSONResponse updateAttendConference(HttpSession session, AttendConference conf) {
        User user = (User) session.getAttribute("currentUser");
        conf.setUserId(user.getUserId());
        return attendConferenceMapper.updateAttendConference(conf);
    }

    /**
     * @Description:按ID查询
     * @param: [session, conf_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
     * @author: yifang
     * @Date: 2018/4/1 10:00
     */
    @RequestMapping("/selectById.do")
    @ResponseBody
    public JSONResponse<AttendConference> selectAttendConferenceById(Integer confId) {
        return attendConferenceMapper.selectAttendConferenceById(confId);
    }

    /**
     * @Description:返回用户拥有的参加学术会议列表
     * @param: [session]
     * @return:
     * @author: yifang
     * @Date: 2018/4/1 10:02
     */
    @RequestMapping("/selectByUserId.do")
    @ResponseBody
    public JSONResponse selectAttendConferenceListByUserId(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        User user = (User) session.getAttribute("currentUser");
        return attendConferenceMapper.selectAttendConferenceListByUserId(user.getUserId(), pageNum, pageSize);
    }


    /**
     * @Description:查询参加学术会议数目
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
     * @author: yifang
     * @Date: 2018/4/1 10:28
     */
    @RequestMapping("/getCount.do")
    @ResponseBody
    public JSONResponse<Integer> getAttendConferenceCountByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return JSONResponse.createBySuccess(0);
        return attendConferenceMapper.getAttendConferenceCountByUserId(user.getUserId());
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 0:01
     * 方法作用：跳转到list
     **/
    @RequestMapping("/list")
    public String showAttendConferenceList() {
        return "/attendconference/list";
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 20:30
     * 方法作用：跳转到add页面
     **/
    @RequestMapping("/add")
    public String showAttendConferenceAdd() {
        return "/attendconference/add";
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
        String path = request.getSession().getServletContext().getRealPath("uploads")  + "\\"+username  + "\\attendconference\\";
        path=path.substring(0,path.indexOf("target"))+"src\\main\\webapp\\"+path.substring(path.indexOf("uploads"));
        JSONResponse<String> upd = fileService.upload(file, path);
        if (!upd.isSuccess())//若上传出错
            return upd;

        String url = upd.getData();
        //上传成功，保存url到filepath表，并返回fileId
       return fileService.updateFilepathInfo(url, userId);



    }


}