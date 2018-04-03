package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.EditBookMapper;
import cn.edu.hstc.pojo.EditBook;
import cn.edu.hstc.service.EditBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author yifang 1307720869@qq.com
 * @date Created in 19:00 2018/3/31
 * @description:
 * @modified by:
 */
@Service
public class EditBookServiceImpl implements EditBookService {
@Autowired
    EditBookMapper editbookMapper;
/**
* @Description:添加参与教材
* @param: [edit]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.EditBook>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addEditBook(EditBook edit) {
        int rs=editbookMapper.insertSelective(edit);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加参与教材成功");
        return JSONResponse.createByErrorMessage("添加参与教材失败");
    }

    /**
    * @Description:根据id删除参与教材
    * @param: [edit_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.EditBook>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteEditBook(Integer edit_id) {
        int rs=editbookMapper.deleteByPrimaryKey(edit_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除参与教材成功");
        return JSONResponse.createByErrorMessage("删除参与教材失败");
    }

/**
* @Description:修改参与教材
* @param: [edit]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.EditBook>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateEditBook(EditBook edit) {

        int rs=editbookMapper.updateByPrimaryKeySelective(edit);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改参与教材成功");
        return JSONResponse.createByErrorMessage("修改参与教材失败");

    }

    /**
    * @Description:根据参与教材的id查询单条记录
    * @param: [edit_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.EditBook>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<EditBook> selectEditBookById(Integer edit_id) {
        EditBook edit=editbookMapper.selectByPrimaryKey(edit_id);
        if(edit!=null)
            return JSONResponse.createBySuccess(edit);
        else
            return JSONResponse.createByErrorMessage("找不到该参与教材");
    }

    /**
    * @Description:根据用户id查询其拥有的参与教材，数据库返回一个EditBook的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.vo.EditBookListVo>
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectEditBookListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<EditBook> edits=editbookMapper.selectByUserId(user_id);
        PageInfo<EditBook> pageInfo = new PageInfo<>(edits);
        return JSONResponse.createBySuccess(pageInfo);
    }

    /**
    * @Description:查询数目
    * @param: [user_id]
    * @return: java.lang.Integer
    * @author: yifang
    * @Date: 2018/4/1 10:08
    */
    @Override
    public JSONResponse<Integer> getEditBookCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=editbookMapper.getEditBookCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
