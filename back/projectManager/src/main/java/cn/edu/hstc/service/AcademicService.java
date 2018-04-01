package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Academic;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @Description:学术论文
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface AcademicService {

    JSONResponse addAcademic(Academic acad);//添加

    JSONResponse deleteAcademic(Integer acad_id);//删除

    JSONResponse updateAcademic(Academic acad);//修改

    JSONResponse<Academic> selectAcademicById(Integer acad_id);//按ID查询

    JSONResponse<PageInfo> selectAcademicListByUserId(Integer user_id,int pageNum,int pageSize);//按用户ID查询论文列表

    JSONResponse<Integer> getAcademicCountByUserId(Integer user_id);
}
