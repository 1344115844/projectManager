package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.AcademicReportMapper;
import cn.edu.hstc.pojo.AcademicReport;
import cn.edu.hstc.service.AcademicReportService;
import cn.edu.hstc.vo.AcademicReportListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author yifang 1307720869@qq.com
 * @date Created in 19:00 2018/4/1
 * @description:
 * @modified by:
 */
@Service
public class AcademicReportServiceImpl implements AcademicReportService {
@Autowired
    AcademicReportMapper academicReportMapper;
/**
* @Description:添加学术报告
* @param: [repo]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AcademicReport>
* @author: yifang
* @Date: 2018/4/1 21:10
*/
    @Override
    public JSONResponse<AcademicReport> addAcademicReport(AcademicReport repo) {
        int rs=academicReportMapper.insertSelective(repo);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加学术报告成功");
        return JSONResponse.createByErrorMessage("添加学术报告失败");
    }

    /**
    * @Description:根据id删除报告
    * @param: [repo_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AcademicReport>
    * @author: yifang
    * @Date: 2018/4/1 21:10
    */
    @Override
    public JSONResponse<AcademicReport> deleteAcademicReport(Integer repo_id) {
        int rs=academicReportMapper.deleteByPrimaryKey(repo_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除学术报告成功");
        return JSONResponse.createByErrorMessage("删除学术报告失败");
    }

/**
* @Description:修改报告
* @param: [repo]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AcademicReport>
* @author: yifang
* @Date: 2018/4/1 21:09
*/
    @Override
    public JSONResponse<AcademicReport> updateAcademicReport(AcademicReport repo) {

        int rs=academicReportMapper.updateByPrimaryKeySelective(repo);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改学术报告成功");
        return JSONResponse.createByErrorMessage("修改学术报告失败");

    }

    /**
    * @Description:根据报告的id查询单条记录
    * @param: [repo_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.AcademicReport>
    * @author: yifang
    * @Date: 2018/4/1 21:09
    */
    @Override
    public JSONResponse<AcademicReport> selectAcademicReportById(Integer repo_id) {
        AcademicReport repo=academicReportMapper.selectByPrimaryKey(repo_id);
        if(repo!=null)
            return JSONResponse.createBySuccess(repo);
        else
            return JSONResponse.createByErrorMessage("找不到该学术报告");
    }

    /**
    * @Description:根据用户id查询其拥有的学术报告，数据库返回一个AcademicReport的集合，封装到VO中
    * @param: [user_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.vo.AcademicReportListVo>
    * @author: yifang
    * @Date: 2018/4/1 21:06
    */
    @Override
    public JSONResponse<AcademicReportListVo> selectAcademicReportListByUserId(Integer user_id) {
        ArrayList<AcademicReport> repos=academicReportMapper.selectByUserId(user_id);
        AcademicReportListVo repolist=new AcademicReportListVo();
        repolist.setRepolist(repos);
        repolist.setUser_id(user_id);
        return JSONResponse.createBySuccess(repolist);//返回一个AcademicReport的集合VO，带有用户信息

    }

    /**
    * @Description:查询数目
    * @param: [user_id]
    * @return: java.lang.Integer
    * @author: yifang
    * @Date: 2018/4/1 10:08
    */
    @Override
    public JSONResponse<Integer> getAcademicReportCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=academicReportMapper.getReportCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
