package cn.edu.hstc.service.impl;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.dao.SpeechMapper;
import cn.edu.hstc.pojo.Speech;
import cn.edu.hstc.service.SpeechService;
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
public class SpeechServiceImpl implements SpeechService {
@Autowired
    SpeechMapper speechMapper;
/**
* @Description:添加受聘讲学
* @param: [speech]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Speech>
* @author: yifang
* @Date: 2018/3/31 21:10
*/
    @Override
    public JSONResponse addSpeech(Speech speech) {
        int rs=speechMapper.insertSelective(speech);
        if(rs==1)return JSONResponse.createBySuccessMessage("添加受聘讲学成功");
        return JSONResponse.createByErrorMessage("添加受聘讲学失败");
    }

    /**
    * @Description:根据id删除受聘讲学
    * @param: [speech_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Speech>
    * @author: yifang
    * @Date: 2018/3/31 21:10
    */
    @Override
    public JSONResponse deleteSpeech(Integer speech_id) {
        int rs=speechMapper.deleteByPrimaryKey(speech_id);
        if(rs==1)return JSONResponse.createBySuccessMessage("删除受聘讲学成功");
        return JSONResponse.createByErrorMessage("删除受聘讲学失败");
    }

/**
* @Description:修改受聘讲学
* @param: [speech]
* @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Speech>
* @author: yifang
* @Date: 2018/3/31 21:09
*/
    @Override
    public JSONResponse updateSpeech(Speech speech) {

        int rs=speechMapper.updateByPrimaryKeySelective(speech);
        if(rs==1)return JSONResponse.createBySuccessMessage("修改受聘讲学成功");
        return JSONResponse.createByErrorMessage("修改受聘讲学失败");

    }

    /**
    * @Description:根据受聘讲学的id查询单条记录
    * @param: [speech_id]
    * @return: cn.edu.hstc.common.JSONResponse<cn.edu.hstc.pojo.Speech>
    * @author: yifang
    * @Date: 2018/3/31 21:09
    */
    @Override
    public JSONResponse<Speech> selectSpeechById(Integer speech_id) {
        Speech speech=speechMapper.selectByPrimaryKey(speech_id);
        if(speech!=null)
            return JSONResponse.createBySuccess(speech);
        else
            return JSONResponse.createByErrorMessage("找不到该受聘讲学");
    }

    /**
    * @Description:根据用户id查询其拥有的受聘讲学，数据库返回一个Speech的集合
     * 使用分页查询，查询第pageNum页，每页pageSize条记录
    * @param: [user_id]
    * @return:
    * @author: yifang
    * @Date: 2018/3/31 21:06
    */
    @Override
    public JSONResponse<PageInfo> selectSpeechListByUserId(Integer user_id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Speech> speechs=speechMapper.selectByUserId(user_id);
        PageInfo<Speech> pageInfo = new PageInfo<>(speechs);
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
    public JSONResponse<Integer> getSpeechCountByUserId(Integer user_id) {
        if(user_id==0)return JSONResponse.createBySuccess(0);
        Integer count=speechMapper.getSpeechCountByUserId(user_id);
        return JSONResponse.createBySuccess(count);
    }

}
