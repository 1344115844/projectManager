package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Study implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private Date begintime;

    private Date overtime;

    private String school;

    private String studycontent;

    private Integer learnerid;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getStudycontent() {
        return studycontent;
    }

    public void setStudycontent(String studycontent) {
        this.studycontent = studycontent == null ? null : studycontent.trim();
    }

    public Integer getLearnerid() {
        return learnerid;
    }

    public void setLearnerid(Integer learnerid) {
        this.learnerid = learnerid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}