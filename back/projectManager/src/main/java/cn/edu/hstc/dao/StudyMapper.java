package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Study;

public interface StudyMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Study record);

    int insertSelective(Study record);

    Study selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Study record);

    int updateByPrimaryKey(Study record);
}