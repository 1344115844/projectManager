package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.AwardMapper;
import cn.edu.hstc.pojo.Award;
import cn.edu.hstc.service.AwardService;
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
public class AwardServiceImpl implements AwardService {
@Autowired
    AwardMapper awardMapper;
/**
* @Description:添加获奖信息
* @param: [award]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addAward(Award award) {
        int rs=awardMapper.insertSelective(award);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加获奖信息成功");
        return JSONResponse.createByErrorMessage("添加获奖信息失败");
    }

    /**
    * @Description:根据id删除获奖信息
    * @param: [award_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteAward(Integer award_id) {
        int rs=awardMapper.deleteByPrimaryKey(award_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除获奖信息成功");
        return JSONResponse.createByErrorMessage("删除获奖信息失败");
    }

/**
* @Description:修改获奖信息
* @param: [award]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateAward(Award award) {

        int rs=awardMapper.updateByPrimaryKeySelective(award);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改获奖信息成功");
        return JSONResponse.createByErrorMessage("修改获奖信息失败");

    }

    /**
    * @Description:根据获奖信息的id查询单条记录
    * @param: [award_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Award>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Award> selectAwardById(Integer award_id) {
        Award award=awardMapper.selectByPrimaryKey(award_id);
        if(award!=null)
            return JSONResponse.createBySuccess(award);
        else
            return JSONResponse.createByErrorMessage("找不到该获奖信息");
    }

    /**
    * @Description:根据用户id查询其拥有的获奖信息，数据库返回一个Award的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectAwardListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Award> awards=awardMapper.selectByUserId(user_id);
        PageInfo<Award> pageInfo = new PageInfo<>(awards);
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
    public JSONResponse<Integer> getAwardCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=awardMapper.getAwardCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
