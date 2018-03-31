package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Unit;

public interface UnitMapper {
    int deleteByPrimaryKey(Integer unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}