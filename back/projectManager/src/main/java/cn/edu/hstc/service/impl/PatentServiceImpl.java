package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.PatentMapper;
import cn.edu.hstc.pojo.Patent;
import cn.edu.hstc.service.PatentService;
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
public class PatentServiceImpl implements PatentService {
@Autowired
    PatentMapper patentMapper;
/**
* @Description:添加专利
* @param: [p]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Patent>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addPatent(Patent p) {
        int rs=patentMapper.insertSelective(p);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加专利成功");
        return JSONResponse.createByErrorMessage("添加专利失败");
    }

    /**
    * @Description:根据id删除专利
    * @param: [p_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Patent>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deletePatent(Integer p_id) {
        int rs=patentMapper.deleteByPrimaryKey(p_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除专利成功");
        return JSONResponse.createByErrorMessage("删除专利失败");
    }

/**
* @Description:修改专利
* @param: [p]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Patent>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updatePatent(Patent p) {

        int rs=patentMapper.updateByPrimaryKeySelective(p);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改专利成功");
        return JSONResponse.createByErrorMessage("修改专利失败");

    }

    /**
    * @Description:根据专利的id查询单条记录
    * @param: [p_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Patent>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Patent> selectPatentById(Integer p_id) {
        Patent p=patentMapper.selectByPrimaryKey(p_id);
        if(p!=null)
            return JSONResponse.createBySuccess(p);
        else
            return JSONResponse.createByErrorMessage("找不到该专利");
    }

    /**
    * @Description:根据用户id查询其拥有的专利，数据库返回一个Patent的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectPatentListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Patent> ps=patentMapper.selectByUserId(user_id);
        PageInfo<Patent> pageInfo = new PageInfo<>(ps);
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
    public JSONResponse<Integer> getPatentCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=patentMapper.getPatentCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
