package cn.edu.hstc.dao;

import cn.edu.hstc.pojo.AcademicReport;

public interface AcademicReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AcademicReport record);

    int insertSelective(AcademicReport record);

    AcademicReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AcademicReport record);

    int updateByPrimaryKey(AcademicReport record);
}