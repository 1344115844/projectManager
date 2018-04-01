package cn.edu.hstc.vo;

import cn.edu.hstc.pojo.AttendConference;

import java.util.List;

/**学术会议的集合
 * @author yifang 1307720869@qq.com
 * @date Created in 20:57 2018/3/31
 * @description:
 * @modified by:
 */
public class AttendConferenceListVo {
    List<AttendConference> conflist;
    int user_id;

    public void setConflist(List<AttendConference> conflist) {
        this.conflist = conflist;
    }

    public List<AttendConference> getConflist() {
        return conflist;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
