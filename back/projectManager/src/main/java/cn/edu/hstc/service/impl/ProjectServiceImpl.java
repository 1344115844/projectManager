package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.ProjectMapper;
import cn.edu.hstc.pojo.Project;
import cn.edu.hstc.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    /**
     * @Description:添加科研项目
     * @param: [pro]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Project>
     * @author: yifang
     * @Date: 2018/3/31 21:10
     */
    @Override
    public JSONResponse addProject(Project pro) {
        int rs = projectMapper.insertSelective(pro);
        if (rs == 1) return JSONResponse.createBySuccessMessage("添加科研项目成功");
        return JSONResponse.createByErrorMessage("添加科研项目失败");
    }

    /**
     * @Description:根据id删除科研项目
     * @param: [pro_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Project>
     * @author: yifang
     * @Date: 2018/3/31 21:10
     */
    @Override
    public JSONResponse deleteProject(Integer pro_id) {
        int rs = projectMapper.deleteByPrimaryKey(pro_id);
        if (rs == 1) return JSONResponse.createBySuccessMessage("删除科研项目成功");
        return JSONResponse.createByErrorMessage("删除科研项目失败");
    }

    /**
     * @Description:修改科研项目
     * @param: [pro]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Project>
     * @author: yifang
     * @Date: 2018/3/31 21:09
     */
    @Override
    public JSONResponse updateProject(Project pro) {

        int rs = projectMapper.updateByPrimaryKeySelective(pro);
        if (rs == 1) return JSONResponse.createBySuccessMessage("修改科研项目成功");
        return JSONResponse.createByErrorMessage("修改科研项目失败");

    }

    /**
     * @Description:根据科研项目的id查询单条记录
     * @param: [pro_id]
     * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Project>
     * @author: yifang
     * @Date: 2018/3/31 21:09
     */
    @Override
    public JSONResponse<Project> selectProjectById(Integer pro_id) {
        Project pro = projectMapper.selectByPrimaryKey(pro_id);
        if (pro != null)
            return JSONResponse.createBySuccess(pro);
        else
            return JSONResponse.createByErrorMessage("找不到该科研项目");
    }

    /**
     * @Description:根据用户id查询其拥有的科研项目，数据库返回一个Project的集合 使用分页查询，查询第pageNum页，每页pageSize条记录
     * @param: [user_id]
     * @return:
     * @author: yifang
     * @Date: 2018/3/31 21:06
     */
    @Override
    public JSONResponse<PageInfo> selectProjectListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ArrayList<Project> pros = projectMapper.selectByUserId(user_id);
        PageInfo<Project> pageInfo = new PageInfo<>(pros);
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
    public JSONResponse<Integer> getProjectCountByUserId(Integer user_id) {
        if (user_id == 0) return JSONResponse.createBySuccess(0);
        Integer count = projectMapper.getProjectCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
