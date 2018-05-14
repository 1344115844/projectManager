package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Role;

import java.util.ArrayList;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/6 21:36
 */
public interface RoleMapper {
    /**
     *@author Veng Su 2018/5/6 22:42
     *方法作用：查询所有角色和权限
     **/
    ArrayList<Role> selectAllRoleAndPermission();

    /**
     *@author Veng Su 2018/5/7 16:33
     *方法作用：查询所有角色
     **/
    ArrayList<Role> selectRoles();

    ArrayList<Role> selectAdminRoles();

    int insertOne(Role role);

    int deleteOneByRoleId(int roleId);
}
