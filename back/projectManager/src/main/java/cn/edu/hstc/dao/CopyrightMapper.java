package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Copyright;

import java.util.ArrayList;

public interface CopyrightMapper {
    int deleteByPrimaryKey(Integer copyId);

    int insert(Copyright record);

    int insertSelective(Copyright record);

    Copyright selectByPrimaryKey(Integer copyId);

    int updateByPrimaryKeySelective(Copyright record);

    int updateByPrimaryKey(Copyright record);


    ArrayList<Copyright> selectByUserId(Integer user_id);//查询用户拥有的软件著作权

    Integer getCopyrightCountByUserId(Integer user_id);//查询用户拥有软件著作权数目
}