package cn.edu.hstc.service;

import cn.edu.hstc.common.JSONResponse;
import cn.edu.hstc.pojo.Speech;
import com.github.pagehelper.PageInfo;

/**
* @Description:受聘讲学
* @author: yifang
* @Date: 2018/3/31 18:58
*/
public interface SpeechService {

    JSONResponse addSpeech(Speech speech);//添加

    JSONResponse deleteSpeech(Integer speech_id);//删除

    JSONResponse updateSpeech(Speech speech);//修改

    JSONResponse<Speech> selectSpeechById(Integer speech_id);//按ID查询

    JSONResponse<PageInfo> selectSpeechListByUserId(Integer user_id, int pageNum, int pageSize);//按用户ID查询列表

    JSONResponse<Integer> getSpeechCountByUserId(Integer user_id);
}
