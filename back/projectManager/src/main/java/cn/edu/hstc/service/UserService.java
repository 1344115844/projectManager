package cn.edu.hstc.service;

import cn.edu.hstc.dao.UserMapper;
import cn.edu.hstc.pojo.User;


public interface UserService {

    User login(String username, String password);

    User register(User user);

    boolean checkValid(String str,String type);

    boolean forgetResetPassword(String username,String passwordNew,String forgetToken);

    boolean resetPassword(String passwordOld,String passwordNew,User user);




}
