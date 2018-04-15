package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Award;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.AwardService;
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
 * @description:获奖信息
 * @modified by:
 */

@Controller
@RequestMapping("/award")
public class AwardController {
    @Autowired
    AwardService awardService;

    @Autowired
    FileService fileService;

    /**
     * @Description:添加获奖信息
     * @param: [session, award]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
     * @author: yifang
     * @Date: 2018/4/1 9:48
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public JSONResponse addAward(HttpSession session, Award award) {
        User user = (User) session.getAttribute("currentUser");
        award.setUserId(user.getUserId());
        return awardService.addAward(award);
    }


    /**
     * @Description:删除获奖信息
     * @param: [session, award_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
     * @author: yifang
     * @Date: 2018/4/1 9:52
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public JSONResponse<Integer> deleteAward(Integer awardId) {
        return awardService.deleteAward(awardId);
    }

    /**
     * @Description:修改获奖信息
     * @param: [session, award]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
     * @author: yifang
     * @Date: 2018/4/1 9:58
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public JSONResponse updateAward(HttpSession session, Award award) {
        User user = (User) session.getAttribute("currentUser");
        award.setUserId(user.getUserId());
        return awardService.updateAward(award);
    }

    /**
     * @Description:按ID查询
     * @param: [session, award_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
     * @author: yifang
     * @Date: 2018/4/1 10:00
     */
    @RequestMapping("/selectById.do")
    @ResponseBody
    public JSONResponse<Award> selectAwardById(Integer awardId) {
        return awardService.selectAwardById(awardId);
    }

    /**
     * @Description:返回用户拥有的获奖信息列表
     * @param: [session]
     * @return:
     * @author: yifang
     * @Date: 2018/4/1 10:02
     */
    @RequestMapping("/selectByUserId.do")
    @ResponseBody
    public JSONResponse selectAwardListByUserId(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        User user = (User) session.getAttribute("currentUser");
        return awardService.selectAwardListByUserId(user.getUserId(), pageNum, pageSize);
    }


    /**
     * @Description:查询获奖信息数目
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
     * @author: yifang
     * @Date: 2018/4/1 10:28
     */
    @RequestMapping("/getCount.do")
    @ResponseBody
    public JSONResponse<Integer> getAwardCountByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return JSONResponse.createBySuccess(0);
        return awardService.getAwardCountByUserId(user.getUserId());
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 0:01
     * 方法作用：跳转到list
     **/
    @RequestMapping("/list")
    public String showAwardList() {
        return "/award/list";
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 20:30
     * 方法作用：跳转到add页面
     **/
    @RequestMapping("/add")
    public String showAwardAdd() {
        return "/award/add";
    }

    /**
     *@author Veng Su
     *@date 2018/4/5 20:07
     *方法作用：跳转到edit页面
     **/
    @RequestMapping("/edit")
    public String showAwardEdit() {
        return "/award/edit";
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
        String path = request.getSession().getServletContext().getRealPath("uploads")  + "\\"+username  + "\\award\\";
//        path=path.substring(0,path.indexOf("target"))+"src\\main\\webapp\\"+path.substring(path.indexOf("uploads"));
        JSONResponse<String> upd = fileService.upload(file, path);
        if (!upd.isSuccess())//若上传出错
            return upd;

        String url =request.getContextPath()+"/uploads"+"/"+username+"/award"+"/"+ upd.getData();

        //上传成功，保存url到filepath表，并返回fileId
       return fileService.updateFilepathInfo(url, userId);



    }


}