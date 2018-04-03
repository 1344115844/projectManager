package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Project;
import com.github.pagehelper.PageInfo;

/**
* @Description:科研项目
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface ProjectService {

    JSONResponse addProject(Project pro);//添加

    JSONResponse deleteProject(Integer pro_id);//删除

    JSONResponse updateProject(Project pro);//修改

    JSONResponse<Project> selectProjectById(Integer pro_id);//按ID查询

    JSONResponse<PageInfo> selectProjectListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getProjectCountByUserId(Integer user_id);
}
