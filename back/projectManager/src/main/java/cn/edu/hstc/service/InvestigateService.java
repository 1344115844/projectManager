package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Investigate;
import com.github.pagehelper.PageInfo;

/**
* @Description:外出考擦
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface InvestigateService {

    JSONResponse addInvestigate(Investigate inv);//添加

    JSONResponse deleteInvestigate(Integer inv_id);//删除

    JSONResponse updateInvestigate(Investigate inv);//修改

    JSONResponse<Investigate> selectInvestigateById(Integer inv_id);//按ID查询

    JSONResponse<PageInfo> selectInvestigateListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getInvestigateCountByUserId(Integer user_id);
}
