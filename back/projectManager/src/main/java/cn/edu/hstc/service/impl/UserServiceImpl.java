package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.UserMapper;
import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.UserService;
import cn.edu.hstc.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * @Description:登录验证处理
     * @param: [username, password]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
     * @author: yifang
     * @Date: 2018/3/30 14:18
     */
    @Override
    public JSONResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return JSONResponse.createByErrorMessage("用户名不存在");
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            return JSONResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return JSONResponse.createBySuccess("login success", user);
    }

    /**
     * @Description:注册处理/admin管理成员
     * @param: [user]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
     * @author: yifang
     * @Date: 2018/3/30 14:17
     */
    @Override
    public JSONResponse<User> register(User user) {
        int ifexists = userMapper.checkUsername(user.getUsername());
        if (ifexists == 1) {
            return JSONResponse.createByErrorMessage("用户名已经存在");
        }

        //用户名还未被注册，可以使用
        //user.setRole(xxx);为用户设置角色
        //密码加密
        user.setPassword(MD5Util.encrypt(user.getUsername(),user.getPassword()));
        //添加到数据库
        int reg = userMapper.insertSelective(user);
        if (reg == 1) {
            return JSONResponse.createBySuccessMessage("注册成功");
        } else {
            return JSONResponse.createByErrorMessage("注册失败");
        }
    }

   /**
   * @Description:修改密码，要求用户输入原密码
   * @param: [user, oldpassword, newpassword]
   * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
   * @author: yifang
   * @Date: 2018/3/30 15:23
   */
    @Override
    public JSONResponse<User> updatePassword(User user, String oldpassword, String newpassword) {

        int resultCount = userMapper.checkOldpassword(user.getUserId(),MD5Util.MD5EncodeUtf8(oldpassword));
        if(resultCount == 0){
            return JSONResponse.createByErrorMessage("原密码错误");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(newpassword));
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if(updateCount > 0){
            return JSONResponse.createBySuccessMessage("修改密码成功");
        }
        return JSONResponse.createByErrorMessage("修改密码失败");

    }

    /**
     *@author Veng Su
     *@date 2018/4/1 9:54
     *@param user
     *@return cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.User>
     *方法作用：admin更新成员信息
     **/
    @Override
    public JSONResponse<User> updateUser(User user) {
        int result=0;
        try{
        result=userMapper.updateByPrimaryKeySelective(user);}
        catch (Exception e){
            return JSONResponse.createByErrorCodeMessage(400,"更新失败，检查表单");
        }
        if (result<0) {
            return JSONResponse.createByErrorCodeMessage(500,"内部错误，更新失败，请检查再提交");
        }else if (result==0){
            return JSONResponse.createByErrorCodeMessage(400,"更新失败，客户端传参失败");
        }else{
            return JSONResponse.createBySuccessMessage("更新成功");
        }
    }
    /**
     *@author Veng Su
     *@date 2018/4/1 10:35
     *方法作用：假删除user，更新delete为1
     **/
    @Override
    public JSONResponse<Integer> deleteUserByUserId(int userId) {
        userMapper.deleteUserByUserId(userId);
        return JSONResponse.createBySuccessMessage("删除成功");
    }

    /**
     *@author Veng Su
     *@date 2018/4/1 20:28
     *方法作用：查询所有user
     **/
    @Override
    public JSONResponse<PageInfo> selectAllUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<User> users=userMapper.selectAllUserList();
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return JSONResponse.createBySuccess(pageInfo);
    }


    @Override
    public JSONResponse<List> selectAllUser() {
        ArrayList<User> users=userMapper.selectAll();
        return JSONResponse.createBySuccess("sucess",users);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userMapper.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }


    @Override
    public void updatePasswordByUsername(String username,String password) {
        userMapper.updatePasswordByUsername(username,password);
    }

    @Override
    public ArrayList<String> getAllUsername() {
        ArrayList<String> userArrayList=userMapper.selectAllusername();
        if (userArrayList!=null){
            return userArrayList;
        }
        return null;
    }
}