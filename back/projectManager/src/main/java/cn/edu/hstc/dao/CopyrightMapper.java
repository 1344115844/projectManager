package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Copyright;

public interface CopyrightMapper {
    int deleteByPrimaryKey(Integer copyId);

    int insert(Copyright record);

    int insertSelective(Copyright record);

    Copyright selectByPrimaryKey(Integer copyId);

    int updateByPrimaryKeySelective(Copyright record);

    int updateByPrimaryKey(Copyright record);
}