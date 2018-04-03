package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.AttendConferenceMapper;
import cn.edu.hstc.pojo.AttendConference;
import cn.edu.hstc.service.AttendConferenceService;
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
public class AttendConferenceServiceImpl implements AttendConferenceService {
@Autowired
    AttendConferenceMapper attendConferenceMapper;
/**
* @Description:添加学术会议
* @param: [conf]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addAttendConference(AttendConference conf) {
        int rs=attendConferenceMapper.insertSelective(conf);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加学术会议成功");
        return JSONResponse.createByErrorMessage("添加学术会议失败");
    }

    /**
    * @Description:根据id删除会议
    * @param: [conf_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteAttendConference(Integer conf_id) {
        int rs=attendConferenceMapper.deleteByPrimaryKey(conf_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除学术会议成功");
        return JSONResponse.createByErrorMessage("删除学术会议失败");
    }

/**
* @Description:修改会议
* @param: [conf]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateAttendConference(AttendConference conf) {

        int rs=attendConferenceMapper.updateByPrimaryKeySelective(conf);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改学术会议成功");
        return JSONResponse.createByErrorMessage("修改学术会议失败");

    }

    /**
    * @Description:根据会议的id查询单条记录
    * @param: [conf_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AttendConference>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<AttendConference> selectAttendConferenceById(Integer conf_id) {
        AttendConference conf=attendConferenceMapper.selectByPrimaryKey(conf_id);
        if(conf!=null)
            return JSONResponse.createBySuccess(conf);
        else
            return JSONResponse.createByErrorMessage("找不到该学术会议");
    }

    /**
    * @Description:根据用户id查询其拥有的学术会议，数据库返回一个AttendConference的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.vo.AttendConferenceListVo>
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectAttendConferenceListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<AttendConference> confs=attendConferenceMapper.selectByUserId(user_id);
        PageInfo<AttendConference> pageInfo = new PageInfo<>(confs);
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
    public JSONResponse<Integer> getAttendConferenceCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=attendConferenceMapper.getConferenceCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
