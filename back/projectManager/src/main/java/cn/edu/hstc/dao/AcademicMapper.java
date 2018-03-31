package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Academic;

import java.util.ArrayList;

public interface AcademicMapper {
    int deleteByPrimaryKey(Integer acadId);

    int insert(Academic record);

    int insertSelective(Academic record);

    Academic selectByPrimaryKey(Integer acadId);

    int updateByPrimaryKeySelective(Academic record);

    int updateByPrimaryKey(Academic record);

    ArrayList<Academic> selectByUserId(Integer user_id);//查询用户拥有的学术论文

    Integer getCountByUserId(Integer user_id);//查询用户拥有学术论文数目
}