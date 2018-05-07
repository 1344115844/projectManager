package cn.edu.hstc.controller.back;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.controller.base.BaseController;
import cn.edu.hstc.pojo.Role;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.RoleService;
import cn.edu.hstc.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     *@author Veng Su
     *@date 2018/3/31 19:32
     *@param
     *@return java.lang.String
     *方法作用：跳转到member-list页面
     **/
    @RequestMapping("/list")
    public String showMember(){
        return "/admin/admin_list";
    }

    @RequestMapping("/permissions/list")
    public String showPermissions(){
        return "/admin/permissions_list";
    }
    @RequestMapping("/roles/list")
    public String showRole(){
        return "/admin/role_list";
    }



    @RequestMapping("/selectAdmin")
    @RequiresRoles("administrator")
    @ResponseBody
    public JSONResponse<ArrayList> selectAdmin(){
        try {
            ArrayList<User> admins= userService.selectAllAdmin();
            return JSONResponse.createBySuccess("success",admins);
        }
        catch (Exception e){
            logger.error("admincontroller 的selectAdmin 出錯");
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
    public JSONResponse selectAllRoleAndPermission(){
        try{
            ArrayList<Role> roles=roleService.selectAllRoleAndPermission();
            return JSONResponse.createBySuccess("success",roles);
        }catch (Exception e){
            logger.error("admin/role/permission接口出错");
            return JSONResponse.createByErrorMessage("内部错误");
        }
    }

    /**
     *@author Veng Su 2018/5/7 16:52
     *方法作用：查询角色
     **/
    @RequestMapping("/selectRoles")
    @ResponseBody
    public JSONResponse selectRoles(){
        try {
            ArrayList<Role> roles= roleService.selectRoles();
            return JSONResponse.createBySuccess("sucess",roles);
        }catch (Exception e){
            return JSONResponse.createByErrorMessage("出错了，内部错误");
        }
    }












}
