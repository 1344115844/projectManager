package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.UserMapper;
import cn.edu.hstc.pojo.User;


public interface UserService {

    JSONResponse<User> login(String username, String password);

    JSONResponse<User> register(User user);


}
