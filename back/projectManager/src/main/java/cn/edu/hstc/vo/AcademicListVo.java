package cn.edu.hstc.vo;

import cn.edu.hstc.pojo.Academic;

import java.util.List;

/**学术论文的集合
 * @author yifang 1307720869@qq.com
 * @date Created in 20:57 2018/3/31
 * @description:
 * @modified by:
 */
public class AcademicListVo {
    List<Academic> acadlist;
    int user_id;

    public void setAcadlist(List<Academic> acadlist) {
        this.acadlist = acadlist;
    }

    public List<Academic> getAcadlist() {
        return acadlist;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
