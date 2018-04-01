package cn.edu.hstc.vo;

import cn.edu.hstc.pojo.Award;

import java.util.List;

/**获奖信息的集合
 * @author yifang 1307720869@qq.com
 * @date Created in 20:57 2018/3/31
 * @description:
 * @modified by:
 */
public class AwardListVo {
    List<Award> awardlist;
    int user_id;

    public void setAcadlist(List<Award> awardlist) {
        this.awardlist = awardlist;
    }

    public List<Award> getAcadlist() {
        return awardlist;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
