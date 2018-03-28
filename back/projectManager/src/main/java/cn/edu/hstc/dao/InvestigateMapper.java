package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Investigate;

public interface InvestigateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Investigate record);

    int insertSelective(Investigate record);

    Investigate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Investigate record);

    int updateByPrimaryKey(Investigate record);
}