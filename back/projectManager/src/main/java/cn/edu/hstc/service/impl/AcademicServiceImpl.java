package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.AcademicMapper;
import cn.edu.hstc.pojo.Academic;
import cn.edu.hstc.service.AcademicService;
//import cn.edu.hstc.vo.AcademicListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yifang 1307720869@qq.com
 * @date Created in 19:00 2018/3/31
 * @description:
 * @modified by:
 */
@Service
public class AcademicServiceImpl implements AcademicService {
@Autowired
    AcademicMapper academicMapper;
/**
* @Description:添加学术论文
* @param: [acad]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addAcademic(Academic acad) {
        int rs=academicMapper.insertSelective(acad);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加学术论文成功");
        return JSONResponse.createByErrorMessage("添加学术论文失败");
    }

    /**
    * @Description:根据id删除论文
    * @param: [acad_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteAcademic(Integer acad_id) {
        int rs=academicMapper.deleteByPrimaryKey(acad_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除学术论文成功");
        return JSONResponse.createByErrorMessage("删除学术论文失败");
    }

/**
* @Description:修改论文
* @param: [acad]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateAcademic(Academic acad) {

        int rs=academicMapper.updateByPrimaryKeySelective(acad);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改学术论文成功");
        return JSONResponse.createByErrorMessage("修改学术论文失败");

    }

    /**
    * @Description:根据论文的id查询单条记录
    * @param: [acad_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Academic>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Academic> selectAcademicById(Integer acad_id) {
        Academic acad=academicMapper.selectByPrimaryKey(acad_id);
        if(acad!=null)
            return JSONResponse.createBySuccess(acad);
        else
            return JSONResponse.createByErrorMessage("找不到该学术论文");
    }

    /**
    * @Description:根据用户id查询其拥有的学术论文，数据库返回一个Academic的集合，封装到VO中
    * @param: [user_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.vo.AcademicListVo>
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<List<Academic>> selectAcademicListByUserId(Integer user_id) {
        ArrayList<Academic> acads=academicMapper.selectByUserId(user_id);

        return JSONResponse.createBySuccess(acads);//返回一个Academic的集合VO，带有用户信息

    }

    /**
    * @Description:查询数目
    * @param: [user_id]
    * @return: java.lang.Integer
    * @author: yifang
    * @Date: 2018/4/1 10:08
    */
    @Override
    public JSONResponse<Integer> getAcademicCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=academicMapper.getAcademicCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
