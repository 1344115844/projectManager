package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;


/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 9:27
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


/*
 *@author suveng
 *@date 2018/3/29 19:07
 *@param []
 *@return java.lang.String
 *方法作用：跳转到主页
 **/
    @RequestMapping("/index")
    public String show() {
        return "index";
    }

    @RequestMapping("/login")
    public String userlogin() {
        return "login";
    }


/*
 *@author suveng
 *@date 2018/3/29 19:07
 *@param [username, password, session]
 *@return cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
 *方法作用：y验证登录
 **/
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse<User> login(String username, String password, HttpSession session) {
        JSONResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute("currentUser", response.getData());
        }
        return response;
    }

    /*
     *@author suveng
     *@date 2018/3/29 19:07
     *@param [session]
     *@return cn.edu.hstc.common.JSONResponse<java.lang.String>
     *方法作用：退出登录
     **/
    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse<String> logout(HttpSession session) {
        session.removeAttribute("currentUser");
        return JSONResponse.createBySuccess();
    }


}
