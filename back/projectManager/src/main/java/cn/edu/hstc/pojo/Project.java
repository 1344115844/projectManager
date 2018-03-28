package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private Integer id;

    private String projectname;

    private Integer projectnumber;

    private String projectsource;

    private Date begintime;

    private Date overtime;

    private Double funds;

    private String level;

    private Integer isteamwork;

    private String state;

    private String projectdirector;

    private Integer fileid;

    private Integer memberid;

    private Date creattime;

    private Date deletetime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public Integer getProjectnumber() {
        return projectnumber;
    }

    public void setProjectnumber(Integer projectnumber) {
        this.projectnumber = projectnumber;
    }

    public String getProjectsource() {
        return projectsource;
    }

    public void setProjectsource(String projectsource) {
        this.projectsource = projectsource == null ? null : projectsource.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getIsteamwork() {
        return isteamwork;
    }

    public void setIsteamwork(Integer isteamwork) {
        this.isteamwork = isteamwork;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getProjectdirector() {
        return projectdirector;
    }

    public void setProjectdirector(String projectdirector) {
        this.projectdirector = projectdirector == null ? null : projectdirector.trim();
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}