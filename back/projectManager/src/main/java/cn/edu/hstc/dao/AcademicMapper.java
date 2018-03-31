package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Academic;

public interface AcademicMapper {
    int deleteByPrimaryKey(Integer acadId);

    int insert(Academic record);

    int insertSelective(Academic record);

    Academic selectByPrimaryKey(Integer acadId);

    int updateByPrimaryKeySelective(Academic record);

    int updateByPrimaryKey(Academic record);
}