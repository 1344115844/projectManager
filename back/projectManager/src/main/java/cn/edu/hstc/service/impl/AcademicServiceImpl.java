package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.AcademicMapper;
import cn.edu.hstc.pojo.Academic;
import cn.edu.hstc.service.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yifang 1307720869@qq.com
 * @date Created in 19:00 2018/3/31
 * @description:
 * @modified by:
 */
public class AcademicServiceImpl implements AcademicService {
@Autowired
    AcademicMapper academicMapper;

    @Override
    public JSONResponse<Academic> addAcademic(Academic acad) {
        int rs=academicMapper.insertSelective(acad);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加学术论文成功");
        return JSONResponse.createByErrorMessage("添加学术论文失败");
    }

    @Override
    public JSONResponse<Academic> deleteAcademic(Integer acad_id) {
        return null;
    }

    @Override
    public JSONResponse<Academic> updateAcademic(Academic acad) {
        return null;
    }

    @Override
    public JSONResponse<Academic> selectAcademicById(Integer acad_id) {
        return null;
    }

    @Override
    public JSONResponse<Academic> selectAcademicListByUserId(Integer user_id) {
        return null;
    }
}
