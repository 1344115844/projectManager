package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Investigate;

import java.util.ArrayList;

public interface InvestigateMapper {
    int deleteByPrimaryKey(Integer invId);

    int insert(Investigate record);

    int insertSelective(Investigate record);

    Investigate selectByPrimaryKey(Integer invId);

    int updateByPrimaryKeySelective(Investigate record);

    int updateByPrimaryKey(Investigate record);

    ArrayList<Investigate> selectByUserId(Integer user_id);//查询用户拥有的外出考察信息

    Integer getInvestigateCountByUserId(Integer user_id);//查询外出考察次数

}