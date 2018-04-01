package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.User;
import com.github.pagehelper.PageInfo;


public interface UserService {

    JSONResponse<User> login(String username, String password);//登录

    JSONResponse<User> register(User user);//注册

    JSONResponse<User> updatePassword(User user,String oldpassword,String newpassword);//修改密码，要求用户输入旧密码



    JSONResponse<User> updateUser(User user);

    JSONResponse<Integer> deleteUserByUserId(int id);

    JSONResponse<PageInfo> selectAllUserList(int pageNum, int pageSize);
}
