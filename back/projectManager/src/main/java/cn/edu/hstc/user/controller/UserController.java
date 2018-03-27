package cn.edu.hstc.user.controller;

import cn.edu.hstc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 9:27
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /*
     *@author suveng
     *@date 2018/3/27 20:30
     *@param []
     *@return java.lang.String
     *方法作用：跳转index页面
     **/

    @RequestMapping("/index")
        public String show() {
        return "index";
    }
}
