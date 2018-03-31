package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.User;
import org.apache.ibatis.annotations.Param;

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


}