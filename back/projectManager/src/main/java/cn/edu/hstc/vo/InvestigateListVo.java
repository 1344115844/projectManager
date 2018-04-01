package cn.edu.hstc.vo;

import cn.edu.hstc.pojo.Investigate;

import java.util.List;

/**外出考察的集合
 * @author yifang 1307720869@qq.com
 * @date Created in 20:57 2018/3/31
 * @description:
 * @modified by:
 */
public class InvestigateListVo {
    List<Investigate> invlist;
    int user_id;

    public void setInvlist(List<Investigate> invlist) {
        this.invlist = invlist;
    }

    public List<Investigate> getInvlist() {
        return invlist;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
