package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Copyright;
import com.github.pagehelper.PageInfo;

/**
* @Description:软件著作权
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface CopyrightService {

    JSONResponse addCopyright(Copyright copy);//添加

    JSONResponse deleteCopyright(Integer copy_id);//删除

    JSONResponse updateCopyright(Copyright copy);//修改

    JSONResponse<Copyright> selectCopyrightById(Integer copy_id);//按ID查询

    JSONResponse<PageInfo> selectCopyrightListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getCopyrightCountByUserId(Integer user_id);
}
