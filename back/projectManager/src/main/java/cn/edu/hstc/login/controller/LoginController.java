package cn.edu.hstc.login.controller;

import cn.edu.hstc.user.entity.User;
import cn.edu.hstc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public User check(@RequestParam String username,@RequestParam String password) {
        User user = new User();
        userService.findUserByUsername();

        return user;
    }
}
