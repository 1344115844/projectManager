package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.InvestigateMapper;
import cn.edu.hstc.pojo.Investigate;
import cn.edu.hstc.service.InvestigateService;
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
public class InvestigateServiceImpl implements InvestigateService {
@Autowired
    InvestigateMapper investigateMapper;
/**
* @Description:添加外出考察
* @param: [inv]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addInvestigate(Investigate inv) {
        int rs=investigateMapper.insertSelective(inv);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加外出考察成功");
        return JSONResponse.createByErrorMessage("添加外出考察失败");
    }

    /**
    * @Description:根据id删除外出考察
    * @param: [inv_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteInvestigate(Integer inv_id) {
        int rs=investigateMapper.deleteByPrimaryKey(inv_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除外出考察成功");
        return JSONResponse.createByErrorMessage("删除外出考察失败");
    }

/**
* @Description:修改外出考察
* @param: [inv]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateInvestigate(Investigate inv) {

        int rs=investigateMapper.updateByPrimaryKeySelective(inv);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改外出考察成功");
        return JSONResponse.createByErrorMessage("修改外出考察失败");

    }

    /**
    * @Description:根据外出考察的id查询单条记录
    * @param: [inv_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Investigate>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Investigate> selectInvestigateById(Integer inv_id) {
        Investigate inv=investigateMapper.selectByPrimaryKey(inv_id);
        if(inv!=null)
            return JSONResponse.createBySuccess(inv);
        else
            return JSONResponse.createByErrorMessage("找不到该外出考察");
    }

    /**
    * @Description:根据用户id查询其拥有的外出考察，数据库返回一个Investigate的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectInvestigateListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Investigate> invs=investigateMapper.selectByUserId(user_id);
        PageInfo<Investigate> pageInfo = new PageInfo<>(invs);
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
    public JSONResponse<Integer> getInvestigateCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=investigateMapper.getInvestigateCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
