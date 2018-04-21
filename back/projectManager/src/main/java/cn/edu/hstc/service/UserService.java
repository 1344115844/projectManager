package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public interface UserService {

    JSONResponse<User> login(String username, String password);//登录

    JSONResponse<User> register(User user);//注册

    JSONResponse<User> updatePassword(User user,String oldpassword,String newpassword);//修改密码，要求用户输入旧密码



    JSONResponse<User> updateUser(User user);//更新用户信息

    JSONResponse<Integer> deleteUserByUserId(int id);//根据id删除用户

    JSONResponse<PageInfo> selectAllUserList(int pageNum, int pageSize);//分页查询全部用户



    JSONResponse<List> selectAllUser();//查询全部成员


    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);

    User getByUsername(String username);

    ArrayList<String> getAllUsername();

    void updatePasswordByUsername(String s,String password);
}
