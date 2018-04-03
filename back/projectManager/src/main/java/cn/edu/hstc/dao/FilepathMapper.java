package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Filepath;

public interface FilepathMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(Filepath record);

    int insertSelective(Filepath record);

    Filepath selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(Filepath record);

    int updateByPrimaryKey(Filepath record);

    int getFileIdByUrl(String url);
}