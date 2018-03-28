package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Award implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private String projectname;

    private String awardname;

    private String awardlevel;

    private Date awardtime;

    private String awardrank;

    private Integer awardid;

    private Integer fileid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname == null ? null : awardname.trim();
    }

    public String getAwardlevel() {
        return awardlevel;
    }

    public void setAwardlevel(String awardlevel) {
        this.awardlevel = awardlevel == null ? null : awardlevel.trim();
    }

    public Date getAwardtime() {
        return awardtime;
    }

    public void setAwardtime(Date awardtime) {
        this.awardtime = awardtime;
    }

    public String getAwardrank() {
        return awardrank;
    }

    public void setAwardrank(String awardrank) {
        this.awardrank = awardrank == null ? null : awardrank.trim();
    }

    public Integer getAwardid() {
        return awardid;
    }

    public void setAwardid(Integer awardid) {
        this.awardid = awardid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}