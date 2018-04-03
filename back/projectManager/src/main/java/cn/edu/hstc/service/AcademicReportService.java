package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.AcademicReport;
import com.github.pagehelper.PageInfo;

/**
* @Description:学术报告
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface AcademicReportService {

    JSONResponse addAcademicReport(AcademicReport repo);//添加

    JSONResponse deleteAcademicReport(Integer repo_id);//删除

    JSONResponse updateAcademicReport(AcademicReport repo);//修改

    JSONResponse<AcademicReport> selectAcademicReportById(Integer repo_id);//按ID查询

    JSONResponse<PageInfo> selectAcademicReportListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询论文列表

    JSONResponse<Integer> getAcademicReportCountByUserId(Integer user_id);
}
