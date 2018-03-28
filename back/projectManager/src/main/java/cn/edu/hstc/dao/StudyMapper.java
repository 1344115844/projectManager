package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Study;

public interface StudyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Study record);

    int insertSelective(Study record);

    Study selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Study record);

    int updateByPrimaryKey(Study record);
}