package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.UnitMapper;
import cn.edu.hstc.pojo.Unit;
import cn.edu.hstc.service.UnitService;
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
public class UnitServiceImpl implements UnitService {
@Autowired
    UnitMapper unitMapper;
/**
* @Description:添加学术团体
* @param: [unit]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Unit>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addUnit(Unit unit) {
        int rs=unitMapper.insertSelective(unit);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加学术团体成功");
        return JSONResponse.createByErrorMessage("添加学术团体失败");
    }

    /**
    * @Description:根据id删除学术团体
    * @param: [unit_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Unit>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteUnit(Integer unit_id) {
        int rs=unitMapper.deleteByPrimaryKey(unit_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除学术团体成功");
        return JSONResponse.createByErrorMessage("删除学术团体失败");
    }

/**
* @Description:修改学术团体
* @param: [unit]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Unit>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateUnit(Unit unit) {

        int rs=unitMapper.updateByPrimaryKeySelective(unit);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改学术团体成功");
        return JSONResponse.createByErrorMessage("修改学术团体失败");

    }

    /**
    * @Description:根据学术团体的id查询单条记录
    * @param: [unit_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Unit>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Unit> selectUnitById(Integer unit_id) {
        Unit unit=unitMapper.selectByPrimaryKey(unit_id);
        if(unit!=null)
            return JSONResponse.createBySuccess(unit);
        else
            return JSONResponse.createByErrorMessage("找不到该学术团体");
    }

    /**
    * @Description:根据用户id查询其拥有的学术团体，数据库返回一个Unit的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectUnitListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Unit> units=unitMapper.selectByUserId(user_id);
        PageInfo<Unit> pageInfo = new PageInfo<>(units);
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
    public JSONResponse<Integer> getUnitCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=unitMapper.getUnitCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
