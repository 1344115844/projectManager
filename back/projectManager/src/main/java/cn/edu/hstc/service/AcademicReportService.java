package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.AcademicReport;
import cn.edu.hstc.vo.AcademicReportListVo;

/**
* @Description:学术报告
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface AcademicReportService {

    JSONResponse<AcademicReport> addAcademicReport(AcademicReport repo);//添加

    JSONResponse<AcademicReport> deleteAcademicReport(Integer repo_id);//删除

    JSONResponse<AcademicReport> updateAcademicReport(AcademicReport repo);//修改

    JSONResponse<AcademicReport> selectAcademicReportById(Integer repo_id);//按ID查询

    JSONResponse<AcademicReportListVo> selectAcademicReportListByUserId(Integer user_id);//按用户ID查询

    JSONResponse<Integer> getAcademicReportCountByUserId(Integer user_id);
}
