package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}