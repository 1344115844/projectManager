package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.CopyrightMapper;
import cn.edu.hstc.pojo.Copyright;
import cn.edu.hstc.service.CopyrightService;
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
public class CopyrightServiceImpl implements CopyrightService {
@Autowired
    CopyrightMapper copyrightMapper;
/**
* @Description:添加软件著作权
* @param: [copy]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Copyright>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addCopyright(Copyright copy) {
        int rs=copyrightMapper.insertSelective(copy);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加软件著作权成功");
        return JSONResponse.createByErrorMessage("添加软件著作权失败");
    }

    /**
    * @Description:根据id删除软件著作权
    * @param: [copy_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Copyright>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteCopyright(Integer copy_id) {
        int rs=copyrightMapper.deleteByPrimaryKey(copy_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除软件著作权成功");
        return JSONResponse.createByErrorMessage("删除软件著作权失败");
    }

/**
* @Description:修改软件著作权
* @param: [copy]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Copyright>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateCopyright(Copyright copy) {

        int rs=copyrightMapper.updateByPrimaryKeySelective(copy);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改软件著作权成功");
        return JSONResponse.createByErrorMessage("修改软件著作权失败");

    }

    /**
    * @Description:根据软件著作权的id查询单条记录
    * @param: [copy_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Copyright>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Copyright> selectCopyrightById(Integer copy_id) {
        Copyright copy=copyrightMapper.selectByPrimaryKey(copy_id);
        if(copy!=null)
            return JSONResponse.createBySuccess(copy);
        else
            return JSONResponse.createByErrorMessage("找不到该软件著作权");
    }

    /**
    * @Description:根据用户id查询其拥有的软件著作权，数据库返回一个Copyright的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectCopyrightListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Copyright> copys=copyrightMapper.selectByUserId(user_id);
        PageInfo<Copyright> pageInfo = new PageInfo<>(copys);
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
    public JSONResponse<Integer> getCopyrightCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=copyrightMapper.getCopyrightCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
