package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    int selectUseridByUserId(Integer userId);
}