package cn.edu.hstc.vo;

import cn.edu.hstc.pojo.AcademicReport;

import java.util.List;

/**学术报告的集合
 * @author yifang 1307720869@qq.com
 * @date Created in 20:57 2018/3/31
 * @description:
 * @modified by:
 */
public class AcademicReportListVo {
    List<AcademicReport> repolist;
    int user_id;

    public void setRepolist(List<AcademicReport> repolist) {
        this.repolist = repolist;
    }

    public List<AcademicReport> getRepolist() {
        return repolist;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
