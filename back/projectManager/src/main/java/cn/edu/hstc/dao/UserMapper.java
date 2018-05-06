package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectLogin(@Param("username") String username, @Param("password")String password);//登录验证

    int checkUsername(String username);//检查用户名

    int checkOldpassword(@Param("user_id") Integer user_id, @Param("oldpassword")String oldpassword);//检查原密码

    int deleteUserByUserId(@Param("userId") Integer userId); //假删除user，更新delete字段为1

    ArrayList<User> selectAllUserList();

    ArrayList<User> selectAll();

    Set<String> getRoles(String username);//获取角色名
    Set<String> getPermissions(String username);//获取权限名

    User getByUsername(String username);//根据username 拿到user对象

    ArrayList<String> selectAllusername();

    void updatePasswordByUsername(@Param("username") String s,@Param("password")String password);

    ArrayList<User> selectAllAdmin();
}