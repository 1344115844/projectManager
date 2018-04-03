package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.AttendConference;
import com.github.pagehelper.PageInfo;

/**
* @Description:学术会议
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface AttendConferenceService {

    JSONResponse addAttendConference(AttendConference conf);//添加

    JSONResponse deleteAttendConference(Integer conf_id);//删除

    JSONResponse updateAttendConference(AttendConference conf);//修改

    JSONResponse<AttendConference> selectAttendConferenceById(Integer conf_id);//按ID查询

    JSONResponse<PageInfo> selectAttendConferenceListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getAttendConferenceCountByUserId(Integer user_id);
}
