package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Unit;

import java.util.ArrayList;

public interface UnitMapper {
    int deleteByPrimaryKey(Integer unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

    ArrayList<Unit> selectByUserId(Integer user_id);//查询用户加入的学术团体

    Integer getUnitCountByUserId(Integer user_id);//查询学术团体数目
}