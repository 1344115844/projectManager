package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Unit;
import com.github.pagehelper.PageInfo;

/**
* @Description:学术团体
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface UnitService {

    JSONResponse addUnit(Unit unit);//添加

    JSONResponse deleteUnit(Integer unit_id);//删除

    JSONResponse updateUnit(Unit unit);//修改

    JSONResponse<Unit> selectUnitById(Integer unit_id);//按ID查询

    JSONResponse<PageInfo> selectUnitListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getUnitCountByUserId(Integer user_id);
}
