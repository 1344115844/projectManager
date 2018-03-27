package cn.edu.hstc.user.service;

import cn.edu.hstc.user.dao.UserMapper;
import cn.edu.hstc.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 9:26
 */

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserByUsername(String username) {
        User user=userMapper.selectByUsername(username);
        return user;
    }
}

