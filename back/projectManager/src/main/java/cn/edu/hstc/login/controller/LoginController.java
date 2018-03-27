package cn.edu.hstc.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 8:49
 */
@Controller

public class LoginController {

    @RequestMapping("login")
    public String login(){

    return "login";
}
}
