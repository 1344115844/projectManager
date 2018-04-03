package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.EditBook;
import com.github.pagehelper.PageInfo;

/**
* @Description:参与教材
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface EditBookService {

    JSONResponse addEditBook(EditBook edit);//添加

    JSONResponse deleteEditBook(Integer edit_id);//删除

    JSONResponse updateEditBook(EditBook edit);//修改

    JSONResponse<EditBook> selectEditBookById(Integer edit_id);//按ID查询

    JSONResponse<PageInfo> selectEditBookListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getEditBookCountByUserId(Integer user_id);
}
