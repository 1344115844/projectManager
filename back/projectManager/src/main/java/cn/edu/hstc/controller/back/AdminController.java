package cn.edu.hstc.controller.back;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.controller.base.BaseController;
import cn.edu.hstc.pojo.Role;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.AdminService;
import cn.edu.hstc.service.RoleService;
import cn.edu.hstc.service.UserService;
import cn.edu.hstc.vo.AddAdmin;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.spec.ECField;
import java.util.ArrayList;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/31 19:18
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController{
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AdminService adminService;
    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     *@author Veng Su
     *@date 2018/3/31 19:32
     *@param
     *@return java.lang.String
     *方法作用：跳转到member-list页面
     **/
    @RequestMapping("/list")
    @RequiresRoles("administrator")
    public String showMember(){
        return "/admin/admin_list";
    }

    @RequestMapping("/permissions/list")
    @RequiresRoles("administrator")
    public String showPermissions(){
        return "/admin/permissions_list";
    }
    @RequestMapping("/roles/list")
    @RequiresRoles("administrator")
    public String showRole(){
        return "/admin/role_list";
    }
    @RequestMapping("/user/list")
    @RequiresRoles("administrator")
    public String showUsers(){
        return "/admin/user_list";
    }
    @RequestMapping("/add")
    public String add(){
        return "/admin/admin_add";
    }



    @RequestMapping("/selectAdmin")
    @RequiresRoles("administrator")
    @ResponseBody
    public JSONResponse<ArrayList> selectAdmin(HttpServletRequest request){
        try {
            ArrayList<User> admins= userService.selectAllAdmin();
            return JSONResponse.createBySuccess("success",admins);
        }
        catch (Exception e){
            logger.error("出错了,uri:{}",request.getRequestURL());
            return JSONResponse.createByErrorMessage("內部錯誤");
        }
    }

    /**
     *@author Veng Su 2018/5/6 22:42
     *方法作用：查询所有角色和权限
     **/
    @RequestMapping("/selectPermissions")
    @ResponseBody
    @RequiresRoles("administrator")
    public JSONResponse selectAllRoleAndPermission(HttpServletRequest request){
        try{
            ArrayList<Role> roles=roleService.selectAllRoleAndPermission();
            return JSONResponse.createBySuccess("success",roles);
        }catch (Exception e){
            logger.error("出错了,uri:{}",request.getRequestURL());
            return JSONResponse.createByErrorMessage("内部错误");
        }
    }

    /**
     *@author Veng Su 2018/5/7 16:52
     *方法作用：查询角色
     **/
    @RequestMapping("/selectRoles")
    @RequiresRoles("administrator")
    @ResponseBody
    public JSONResponse selectRoles(HttpServletRequest request){
        try {
            ArrayList<Role> roles= roleService.selectRoles();
            return JSONResponse.createBySuccess("success",roles);
        }catch (Exception e){
            logger.error("出错了,uri:{}",request.getRequestURL());
            return JSONResponse.createByErrorMessage("出错了，内部错误");
        }
    }
    /**
     *@author Veng Su 2018/5/10 14:32
     *方法作用：查询所有成员
     **/
    @RequestMapping("/selectUsers")
    @RequiresRoles("administrator")
    @ResponseBody
    public JSONResponse selectUsers(HttpServletRequest request,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        try {

            PageInfo<User> pageInfo= userService.selectUsers(pageNum,pageSize);
            return JSONResponse.createBySuccess("success",pageInfo);
        }catch (Exception e){
            logger.error("出错了,uri:{}",request.getRequestURL());
            return JSONResponse.createByErrorMessage("出错了，内部错误");
        }
    }
    /**
     *@author Veng Su 2018/5/12 16:58
     *方法作用：查找全部角色
     **/
    @RequestMapping("/findRoles")
    @RequiresRoles("administrator")
    @ResponseBody
    public JSONResponse findRoles(HttpServletRequest request){
        try{
            ArrayList roles =roleService.selectAdminRoles();
            return JSONResponse.createBySuccess("success",roles);
        }catch (Exception e){
            logger.error("出错了，uri{}",request.getRequestURL());
            return JSONResponse.createByErrorMessage("出错了，内部错误");
        }
    }

    @RequestMapping("role/add")
    @RequiresRoles("administrator")
    @ResponseBody
    public JSONResponse addRole(HttpServletRequest request,AddAdmin addAdmin){
        try {
            adminService.addRole(addAdmin);
            return JSONResponse.createBySuccess("success");
        }catch (Exception e){
            logger.error("出错了，uri{}",request.getRequestURL());
            return JSONResponse.createByErrorMessage("出错了，存在脏数据，请与管理员联系");
        }
    }



}
