package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.AcademicReport;

public interface AcademicReportMapper {
    int deleteByPrimaryKey(Integer repId);

    int insert(AcademicReport record);

    int insertSelective(AcademicReport record);

    AcademicReport selectByPrimaryKey(Integer repId);

    int updateByPrimaryKeySelective(AcademicReport record);

    int updateByPrimaryKey(AcademicReport record);
}