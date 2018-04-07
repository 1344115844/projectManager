package cn.edu.hstc.controller.front;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.common.ResponseCode;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.UserService;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 9:27
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


/**
 *@author suveng
 *@date 2018/3/29 19:07
 *@param
 *@return java.lang.String
 *方法作用：跳转到主页
 **/
    @RequestMapping("/index")
    public String show() {
        return "/user/index";
    }

    @RequestMapping("/login")
    public String userLogin() {
        return "/login/login";
    }

    @RequestMapping("/register")
    public String userRegister() {
        return "register";
    }
/**
 *@author suveng
 *@date 2018/3/29 19:07
 *@param username, password, session
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

    /**
     *@author suveng
     *@date 2018/3/29 19:07
     *@param session
     *@return cn.edu.hstc.common.JSONResponse<java.lang.String>
     *方法作用：退出登录
     **/
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    @ResponseBody
    public JSONResponse<String> logout(HttpSession session) {
        session.removeAttribute("currentUser");
        return JSONResponse.createBySuccess();
    }

    /**
    * @Description:处理注册提交的表单
    * @param: [user]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
    * @author: yifang
    * @Date: 2018/3/30 14:18
    */
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse<User> register(User user) {
        return userService.register(user);
    }

/**
* @Description:修改密码
* @param: [session, oldpassword, newpassword]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
* @author: yifang
* @Date: 2018/3/30 15:31
*/
    @RequestMapping(value = "/updatepassword.do", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse<User> updatePassword(HttpSession session,String oldpassword,String newpassword) {
        User user=(User)session.getAttribute("currentUser");
        if(user==null) return JSONResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());//若用户未登录
        return userService.updatePassword(user,oldpassword,newpassword);
    }
    /**
     *@author Veng Su
     *@date 2018/4/1 19:43
     *方法作用：分页查询全部成员
     **/
    @RequestMapping("/select/all")
    @ResponseBody
    public JSONResponse<PageInfo> selectUserListById(int pageNum, int pageSize){
        return userService.selectAllUserList(pageNum,pageSize);
    }

    /**
     *@author Veng Su
     *@date 2018/4/7 15:11
     *方法作用：查询全部成员
     **/
    @RequestMapping("/all")
    @ResponseBody
    public JSONResponse<List> selectUserList(){
        return userService.selectAllUser();
    }

    /**
     *@author Veng Su
     *@date 2018/4/1 10:06
     *方法作用：删除一个成员，假删除方式,更新deleted为1
     **/
    @RequestMapping("/delete/one")
    @ResponseBody
    public JSONResponse<Integer> deleteUserByUserId(int userId){
        return userService.deleteUserByUserId(userId);
    }

    /**
     *@author Veng Su
     *@date 2018/4/1 9:55
     *@param user
     *@return cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
     *方法作用：管理员更新user信息
     **/

    @RequestMapping("/update/one")
    @ResponseBody
    public JSONResponse<User> updateUser(User user){
        return userService.updateUser(user);
    }

    /**
     *@author Veng Su
     *@date 2018/4/1 9:21
     *@param user
     *@return cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
     *方法作用：添加user
     **/
    @RequestMapping("/add/one")
    @ResponseBody
    public JSONResponse<User> addUser(User user){
        return userService.register(user);
    }
    
    /**
     *@author Veng Su
     *@date 2018/4/4 8:07
     *方法作用：获取welcome页面
     **/
    @RequestMapping("/index/welcome")

    public String showWelcome(){
        return "/user/welcome";
    }


}
