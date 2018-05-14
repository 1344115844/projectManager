package cn.edu.hstc.service.impl;

import cn.edu.hstc.dao.UserMapper;
import cn.edu.hstc.dao.UserRoleMapper;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.pojo.UserRole;
import cn.edu.hstc.service.AdminService;
import cn.edu.hstc.util.MD5Util;
import cn.edu.hstc.vo.AddAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/12 17:13
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void addRole(AddAdmin addAdmin) {
        try {
            User role=new User();
            role.setName(addAdmin.getName());
            role.setUsername(addAdmin.getUsername());
            role.setPassword(MD5Util.encrypt(addAdmin.getUsername(),addAdmin.getPassword()));
            userMapper.insertSelective(role);
            role=userMapper.getByUsername(role.getUsername());
            int res=userRoleMapper.selectUseridByUserId(role.getUserId());
            if (res!=0){
                logger.error("存在脏数据，请与管理员联系");
                throw new Exception("存在脏数据，请与管理员联系");
            }else {
                UserRole userRole=new UserRole();
                userRole.setUserId(role.getUserId());
                userRole.setRoleId(addAdmin.getRoleId());
                userRoleMapper.insert(userRole);
            }
        }catch (Exception e){
            logger.error("出错了，添加管理员失败");
            throw new RuntimeException();
        }

    }

    @Override
    public void del(int userId) {
        try {
            int a=userMapper.deleteByPrimaryKey(userId);
            int b=userRoleMapper.deleteUserRoleByUserId(userId);
            if (a<=0||b<=0){
                logger.error("删除失败，存在脏数据");
                throw new Exception("删除失败，存在脏数据");
            }
        }catch (Exception e){
            logger.error("出错了,删除管理员失败");
            throw new RuntimeException();
        }

    }
}
