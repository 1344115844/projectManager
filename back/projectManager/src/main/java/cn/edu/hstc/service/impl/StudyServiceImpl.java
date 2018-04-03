package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.StudyMapper;
import cn.edu.hstc.pojo.Study;
import cn.edu.hstc.service.StudyService;
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
public class StudyServiceImpl implements StudyService {
@Autowired
    StudyMapper studyMapper;
/**
* @Description:添加进修学习
* @param: [stu]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addStudy(Study stu) {
        int rs=studyMapper.insertSelective(stu);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加进修学习成功");
        return JSONResponse.createByErrorMessage("添加进修学习失败");
    }

    /**
    * @Description:根据id删除进修学习
    * @param: [stu_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteStudy(Integer stu_id) {
        int rs=studyMapper.deleteByPrimaryKey(stu_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除进修学习成功");
        return JSONResponse.createByErrorMessage("删除进修学习失败");
    }

/**
* @Description:修改进修学习
* @param: [stu]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateStudy(Study stu) {

        int rs=studyMapper.updateByPrimaryKeySelective(stu);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改进修学习成功");
        return JSONResponse.createByErrorMessage("修改进修学习失败");

    }

    /**
    * @Description:根据进修学习的id查询单条记录
    * @param: [stu_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Study>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Study> selectStudyById(Integer stu_id) {
        Study stu=studyMapper.selectByPrimaryKey(stu_id);
        if(stu!=null)
            return JSONResponse.createBySuccess(stu);
        else
            return JSONResponse.createByErrorMessage("找不到该进修学习");
    }

    /**
    * @Description:根据用户id查询其拥有的进修学习，数据库返回一个Study的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectStudyListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Study> stus=studyMapper.selectByUserId(user_id);
        PageInfo<Study> pageInfo = new PageInfo<>(stus);
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
    public JSONResponse<Integer> getStudyCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=studyMapper.getStudyCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
