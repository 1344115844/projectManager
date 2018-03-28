package cn.edu.hstc.controller.front;

import cn.edu.hstc.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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

    @RequestMapping("/check")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        String username = request.getParameter("username");
        String pwd=request.getParameter("password");
        //查数据库 如果查到数据  调用MD5加密对比密码
        User user = userService.findUserByUserName(username);
        if(user!=null){
            if(SecurityUtils.checkPassword(pwd,user.getPassword())){
                //校验成功  设置session
                request.getSession().setAttribute("userinfo",user);
                return "login_succ";
            }else{
                // 校验失败  返回校验失败signal
                return "login_fail";
            }
        }else {
            // 校验失败  返回校验失败signal
            return "login_fail";
        }

    }



    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        userService.createUser(user);

        return "succ";
    }



}