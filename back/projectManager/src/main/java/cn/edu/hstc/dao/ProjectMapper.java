package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Project;

import java.util.ArrayList;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    ArrayList<Project> selectByUserId(Integer user_id);//查询用户参加的科研项目

    Integer getProjectCountByUserId(Integer user_id);//查询科研项目数目
}