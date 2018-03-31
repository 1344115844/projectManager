package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}