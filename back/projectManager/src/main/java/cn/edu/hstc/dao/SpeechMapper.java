package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Speech;

public interface SpeechMapper {
    int deleteByPrimaryKey(Integer speechId);

    int insert(Speech record);

    int insertSelective(Speech record);

    Speech selectByPrimaryKey(Integer speechId);

    int updateByPrimaryKeySelective(Speech record);

    int updateByPrimaryKey(Speech record);
}