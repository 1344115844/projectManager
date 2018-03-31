package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}