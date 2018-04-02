package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.AcademicReport;

import java.util.ArrayList;

public interface AcademicReportMapper {
    int deleteByPrimaryKey(Integer repId);

    int insert(AcademicReport record);

    int insertSelective(AcademicReport record);

    AcademicReport selectByPrimaryKey(Integer repId);

    int updateByPrimaryKeySelective(AcademicReport record);

    int updateByPrimaryKey(AcademicReport record);

    ArrayList<AcademicReport> selectByUserId(Integer user_id);//查询用户拥有的学术报告

    Integer getReportCountByUserId(Integer user_id);//查询用户拥有学术报告数目



}