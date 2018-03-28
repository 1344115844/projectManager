package cn.edu.hstc.login.controller;

import cn.edu.hstc.user.entity.User;
import cn.edu.hstc.user.service.UserService;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 8:49
 */

/**
 * login登录，跳转页面
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping
    public String login() {
        return "login";
    }

    /**
     *
     * @return user[authority,username]
     */
    @RequestMapping("/check")
    @ResponseBody
    public User check(HttpServletRequest request) {
        User user = null;
        user=userService.findUserByUsername(request.getParameter("username"));
        if(user!=null){
            request.getSession().setAttribute("userinfo",user);
        }
        return user;
    }
}
