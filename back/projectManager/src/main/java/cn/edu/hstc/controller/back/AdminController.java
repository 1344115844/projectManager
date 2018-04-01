package cn.edu.hstc.controller.back;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/31 19:18
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    UserService userService;

    /**
     *@author Veng Su
     *@date 2018/3/31 19:32
     *@param
     *@return java.lang.String
     *方法作用：跳转到member-list页面
     **/
    @RequestMapping("/show/user-list")
    @ResponseBody
    public String showMember(){
        return "member-list";
    }


/**
 *@author Veng Su
 *@date 2018/4/1 9:21
 *@param user
 *@return cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
 *方法作用：管理员添加成员
 **/
    @RequestMapping("add/user")
    @ResponseBody
    public JSONResponse<User> addUser(User user){
        return userService.register(user);
    }

/**
 *@author Veng Su
 *@date 2018/4/1 9:55
 *@param user
 *@return cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
 *方法作用：管理员更新成员信息
 **/

    @RequestMapping("update/user")
    @ResponseBody
    public JSONResponse<User> updateUser(User user){
        return userService.updateUser(user);
    }


    /**
     *@author Veng Su
     *@date 2018/4/1 10:06
     *方法作用：admin删除成员，假删除方式
     **/
    @RequestMapping("delete/user")
    @ResponseBody
    public JSONResponse<Integer> deleteUserByUserId(int userId){
        return userService.deleteUserByUserId(userId);
    }



}
