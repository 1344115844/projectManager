package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Patent;

import java.util.ArrayList;

public interface PatentMapper {
    int deleteByPrimaryKey(Integer tentId);

    int insert(Patent record);

    int insertSelective(Patent record);

    Patent selectByPrimaryKey(Integer tentId);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record);

    ArrayList<Patent> selectByUserId(Integer user_id);//查询用户申请的专利信息

    Integer getPatentCountByUserId(Integer user_id);//查询专利数目
}