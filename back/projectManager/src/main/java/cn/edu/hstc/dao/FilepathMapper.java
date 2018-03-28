package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Filepath;

public interface FilepathMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Filepath record);

    int insertSelective(Filepath record);

    Filepath selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Filepath record);

    int updateByPrimaryKey(Filepath record);
}