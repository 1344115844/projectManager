package cn.edu.hstc.service.impl;

import cn.edu.hstc.dao.RoleMapper;
import cn.edu.hstc.pojo.Role;
import cn.edu.hstc.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/6 21:52
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     *@author Veng Su 2018/5/6 22:42
     *方法作用：查询所有角色和权限
     **/
    @Override
    public ArrayList<Role> selectAllRoleAndPermission() {
        try {
            ArrayList<Role> roles= roleMapper.selectAllRoleAndPermission();
            return roles;
        }catch (Exception e){
            logger.error("roleService selectAllRoleAndPermission（）出错了");
            throw e;
        }
    }

    /**
     *@author Veng Su 2018/5/7 16:52
     *方法作用：查询所有角色
     **/
    @Override
    public ArrayList<Role> selectRoles() {
        try {
            return roleMapper.selectRoles();
        }catch (Exception e){
            logger.error("出错了，位置：{}",this.toString());
            throw e;
        }
    }
}
