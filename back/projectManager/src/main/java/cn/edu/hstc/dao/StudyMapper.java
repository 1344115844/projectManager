package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Study;

import java.util.ArrayList;

public interface StudyMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Study record);

    int insertSelective(Study record);

    Study selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Study record);

    int updateByPrimaryKey(Study record);

    ArrayList<Study> selectByUserId(Integer user_id);//查询用户参加的进修学习

    Integer getStudyCountByUserId(Integer user_id);//查询进修学习次数
}