package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Academic;
import cn.edu.hstc.vo.AcademicListVo;

import java.util.ArrayList;

/**
* @Description:学术论文
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface AcademicService {

    JSONResponse<Academic> addAcademic(Academic acad);//添加

    JSONResponse<Academic> deleteAcademic(Integer acad_id);//删除

    JSONResponse<Academic> updateAcademic(Academic acad);//修改

    JSONResponse<Academic> selectAcademicById(Integer acad_id);//按ID查询

    JSONResponse<AcademicListVo> selectAcademicListByUserId(Integer user_id);//按用户ID查询

    JSONResponse<Integer> getAcademicCountByUserId(Integer user_id);
}
