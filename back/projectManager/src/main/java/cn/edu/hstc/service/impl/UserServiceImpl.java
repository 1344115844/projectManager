package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.UserMapper;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.UserService;
import cn.edu.hstc.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public JSONResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if(resultCount == 0 ){
            return JSONResponse.createByErrorMessage("用户名不存在");
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user  = userMapper.selectLogin(username,md5Password);
        if(user == null){
            return JSONResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return JSONResponse.createBySuccess("login success",user);
    }

    @Override
    public JSONResponse<User> register(User user) {
        int ifexists = userMapper.checkUsername(user.getUsername());
        if(ifexists == 1 ){
            return JSONResponse.createByErrorMessage("用户名已经存在");
        }

        //用户名还未被注册，可以使用
        //user.setRole(xxx);为用户设置角色
        //密码加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        //添加到数据库
        int reg=userMapper.insertSelective(user);
        if(reg==1){
            return JSONResponse.createBySuccessMessage("注册成功");
        }else{
            return JSONResponse.createByErrorMessage("注册失败");
        }
    }
}
