package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Investigate;

public interface InvestigateMapper {
    int deleteByPrimaryKey(Integer invId);

    int insert(Investigate record);

    int insertSelective(Investigate record);

    Investigate selectByPrimaryKey(Integer invId);

    int updateByPrimaryKeySelective(Investigate record);

    int updateByPrimaryKey(Investigate record);
}