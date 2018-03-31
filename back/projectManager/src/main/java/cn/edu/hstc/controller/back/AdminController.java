package cn.edu.hstc.controller.back;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/31 19:18
 */
@Controller
@RequestMapping("admin")
public class AdminController {


    /**
     *@author Veng Su
     *@date 2018/3/31 19:32
     *@param []
     *@return java.lang.String
     *方法作用：跳转到member-list页面
     **/
    @RequestMapping("/show/user-list")
    public String showMember(){
        return "member-list";
    }

    @RequestMapping("add/user")
    public JSONResponse<User> addUser(){
        return null;
    }


}
