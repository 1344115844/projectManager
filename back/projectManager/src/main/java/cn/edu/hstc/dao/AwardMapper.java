package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Award;

public interface AwardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Award record);

    int insertSelective(Award record);

    Award selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);
}