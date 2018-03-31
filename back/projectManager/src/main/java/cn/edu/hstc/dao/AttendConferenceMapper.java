package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.AttendConference;

public interface AttendConferenceMapper {
    int deleteByPrimaryKey(Integer confId);

    int insert(AttendConference record);

    int insertSelective(AttendConference record);

    AttendConference selectByPrimaryKey(Integer confId);

    int updateByPrimaryKeySelective(AttendConference record);

    int updateByPrimaryKey(AttendConference record);
}