package cn.edu.hstc.service;

import cn.edu.hstc.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/6 21:35
 */

public interface RoleService {
    /**
     *@author Veng Su 2018/5/6 22:42
     *方法作用：查询所有角色和权限
     **/
    ArrayList<Role>  selectAllRoleAndPermission();

    /**
     *@author Veng Su 2018/5/7 16:52
     *方法作用：查询所有角色
     **/
    ArrayList<Role> selectRoles();

    ArrayList selectAdminRoles();

    void addRole(Role role);

    int delRole(Role role);
}
