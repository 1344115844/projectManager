package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Patent;
import com.github.pagehelper.PageInfo;

/**
* @Description:专利
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface PatentService {

    JSONResponse addPatent(Patent p);//添加

    JSONResponse deletePatent(Integer tentId);//删除

    JSONResponse updatePatent(Patent p);//修改

    JSONResponse<Patent> selectPatentById(Integer p_id);//按ID查询

    JSONResponse<PageInfo> selectPatentListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getPatentCountByUserId(Integer user_id);
}
