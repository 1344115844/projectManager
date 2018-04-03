package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Study;
import com.github.pagehelper.PageInfo;

/**
* @Description:进修学习
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface StudyService {

    JSONResponse addStudy(Study stu);//添加

    JSONResponse deleteStudy(Integer stu_id);//删除

    JSONResponse updateStudy(Study stu);//修改

    JSONResponse<Study> selectStudyById(Integer stu_id);//按ID查询

    JSONResponse<PageInfo> selectStudyListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getStudyCountByUserId(Integer user_id);
}
