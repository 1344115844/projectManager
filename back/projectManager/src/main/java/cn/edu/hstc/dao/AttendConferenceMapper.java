package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.AttendConference;

import java.util.ArrayList;

public interface AttendConferenceMapper {
    int deleteByPrimaryKey(Integer confId);

    int insert(AttendConference record);

    int insertSelective(AttendConference record);

    AttendConference selectByPrimaryKey(Integer confId);

    int updateByPrimaryKeySelective(AttendConference record);

    int updateByPrimaryKey(AttendConference record);

    ArrayList<AttendConference> selectByUserId(Integer user_id);//查询用户参加的学术会议

    Integer getConferenceCountByUserId(Integer user_id);//查询参加学术会议数目
}