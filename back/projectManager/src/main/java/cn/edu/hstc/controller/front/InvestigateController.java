package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Investigate;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.InvestigateService;
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
 * @description:外出考察
 * @modified by:
 */

@Controller
@RequestMapping("/investigate")
public class InvestigateController {
    @Autowired
    InvestigateService investigateService;

    @Autowired
    FileService fileService;

    /**
     * @Description:添加外出考察
     * @param: [session, investigate]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
     * @author: yifang
     * @Date: 2018/4/1 9:48
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public JSONResponse addInvestigate(HttpSession session, Investigate inv) {
        User user = (User) session.getAttribute("currentUser");
        inv.setUserId(user.getUserId());
        return investigateService.addInvestigate(inv);
    }


    /**
     * @Description:删除外出考察
     * @param: [session, inv_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
     * @author: yifang
     * @Date: 2018/4/1 9:52
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public JSONResponse<Integer> deleteInvestigate(Integer invId) {
        return investigateService.deleteInvestigate(invId);
    }

    /**
     * @Description:修改外出考察
     * @param: [session, investigate]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
     * @author: yifang
     * @Date: 2018/4/1 9:58
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public JSONResponse updateInvestigate(HttpSession session, Investigate inv) {
        User user = (User) session.getAttribute("currentUser");
        inv.setUserId(user.getUserId());
        return investigateService.updateInvestigate(inv);
    }

    /**
     * @Description:按ID查询
     * @param: [session, invId]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
     * @author: yifang
     * @Date: 2018/4/1 10:00
     */
    @RequestMapping("/selectById.do")
    @ResponseBody
    public JSONResponse<Investigate> selectInvestigateById(Integer invId) {
        return investigateService.selectInvestigateById(invId);
    }

    /**
     * @Description:返回用户拥有的外出考察列表
     * @param: [session]
     * @return:
     * @author: yifang
     * @Date: 2018/4/1 10:02
     */
    @RequestMapping("/selectByUserId.do")
    @ResponseBody
    public JSONResponse selectInvestigateListByUserId(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        User user = (User) session.getAttribute("currentUser");
        return investigateService.selectInvestigateListByUserId(user.getUserId(), pageNum, pageSize);
    }


    /**
     * @Description:查询外出考察数目
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
     * @author: yifang
     * @Date: 2018/4/1 10:28
     */
    @RequestMapping("/getCount.do")
    @ResponseBody
    public JSONResponse<Integer> getInvestigateCountByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return JSONResponse.createBySuccess(0);
        return investigateService.getInvestigateCountByUserId(user.getUserId());
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 0:01
     * 方法作用：跳转到list
     **/
    @RequestMapping("/list")
    public String showInvestigateList() {
        return "/investigate/list";
    }

    /**
     * @author Veng Su
     * @date 2018/4/2 20:30
     * 方法作用：跳转到add页面
     **/
    @RequestMapping("/add")
    public String showInvestigateAdd() {
        return "/investigate/add";
    }

/**
 *@author Veng Su
 *@date 2018/4/6 13:48
 *方法作用：跳转到edit页面
 **/
    @RequestMapping("/edit")
    public String showInvestigateEdit() {
        return "/investigate/edit";
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
        String path = request.getSession().getServletContext().getRealPath("uploads") + "\\" + username + "\\investigate\\";
//        path = path.substring(0, path.indexOf("target")) + "src\\main\\webapp\\" + path.substring(path.indexOf("uploads"));
        JSONResponse<String> upd = fileService.upload(file, path);
        if (!upd.isSuccess())//若上传出错
            return upd;

        String url = upd.getData();
        //上传成功，保存url到filepath表，并返回fileId
        return fileService.updateFilepathInfo(url, userId);


    }


}