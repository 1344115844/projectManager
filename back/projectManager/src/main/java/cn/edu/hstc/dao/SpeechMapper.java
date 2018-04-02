package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.Speech;

import java.util.ArrayList;

public interface SpeechMapper {
    int deleteByPrimaryKey(Integer speechId);

    int insert(Speech record);

    int insertSelective(Speech record);

    Speech selectByPrimaryKey(Integer speechId);

    int updateByPrimaryKeySelective(Speech record);

    int updateByPrimaryKey(Speech record);

    ArrayList<Speech> selectByUserId(Integer user_id);//查询用户参加的受聘讲学

    Integer getSpeechCountByUserId(Integer user_id);//查询受聘讲学次数
}