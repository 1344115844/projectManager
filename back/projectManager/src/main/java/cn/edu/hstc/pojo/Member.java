package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private Integer id;

    private String name;

    private String jobtitle;

    private String education;

    private String researchdirection;

    private String academictitle;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getResearchdirection() {
        return researchdirection;
    }

    public void setResearchdirection(String researchdirection) {
        this.researchdirection = researchdirection == null ? null : researchdirection.trim();
    }

    public String getAcademictitle() {
        return academictitle;
    }

    public void setAcademictitle(String academictitle) {
        this.academictitle = academictitle == null ? null : academictitle.trim();
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
}