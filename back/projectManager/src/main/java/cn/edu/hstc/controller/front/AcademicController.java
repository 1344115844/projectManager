package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.common.ResponseCode;
import cn.edu.hstc.pojo.Academic;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.AcademicService;
import cn.edu.hstc.vo.AcademicListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * @Description:添加学术论文
     * @param: [session, acad]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
     * @author: yifang
     * @Date: 2018/4/1 9:48
     */
    @RequestMapping("/add.do")
    public JSONResponse<Academic> addAcademic(HttpSession session, Academic acad) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null)
            return JSONResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());//若用户未登录
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
    public JSONResponse<Academic> deleteAcademic(HttpSession session, Integer acad_id) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null)
            return JSONResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());//若用户未登录
        return academicService.deleteAcademic(acad_id);
    }

    /**
     * @Description:修改学术论文
     * @param: [session, acad]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
     * @author: yifang
     * @Date: 2018/4/1 9:58
     */
    @RequestMapping("/update.do")
    public JSONResponse<Academic> updateAcademic(HttpSession session, Academic acad) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null)
            return JSONResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());//若用户未登录
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
    public JSONResponse<Academic> selectAcademicById(HttpSession session, Integer acad_id) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null)
            return JSONResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());//若用户未登录
        return academicService.selectAcademicById(acad_id);
    }

    /**
     * @Description:返回用户拥有的学术论文列表
     * @param: [session]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.vo.AcademicListVo>
     * @author: yifang
     * @Date: 2018/4/1 10:02
     */
    @RequestMapping("/selectByUserId.do")
    public JSONResponse<AcademicListVo> selectAcademicListByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null)
            return JSONResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());//若用户未登录
        return academicService.selectAcademicListByUserId(user.getUserId());
    }


    /**
    * @Description:查询学术论文数目
    * @param: [session]
    * @return: cn.edu.hstc.common.JSONResponse<java.lang.Integer>
    * @author: yifang
    * @Date: 2018/4/1 10:28
    */
    @RequestMapping("/getCount.do")
    public JSONResponse<Integer> getAcademicCountByUserId(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if(user==null) return JSONResponse.createBySuccess(0);
        return academicService.getAcademicCountByUserId(user.getUserId());
    }

}
