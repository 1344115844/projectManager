package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Award;
import com.github.pagehelper.PageInfo;

/**
* @Description:获奖情况
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface AwardService {

    JSONResponse addAward(Award award);//添加

    JSONResponse deleteAward(Integer award_id);//删除

    JSONResponse updateAward(Award award);//修改

    JSONResponse<Award> selectAwardById(Integer award_id);//按ID查询

    JSONResponse<PageInfo> selectAwardListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getAwardCountByUserId(Integer user_id);
}
