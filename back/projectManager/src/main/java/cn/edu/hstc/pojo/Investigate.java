package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Investigate implements Serializable {
    private Integer id;

    private Date deletetime;

    private Date updatetime;

    private Date createtime;

    private Date begintime;

    private Date overtime;

    private String investigateplace;

    private String investigatecontent;

    private Integer investigatorid;

    private Integer fileid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public String getInvestigateplace() {
        return investigateplace;
    }

    public void setInvestigateplace(String investigateplace) {
        this.investigateplace = investigateplace == null ? null : investigateplace.trim();
    }

    public String getInvestigatecontent() {
        return investigatecontent;
    }

    public void setInvestigatecontent(String investigatecontent) {
        this.investigatecontent = investigatecontent == null ? null : investigatecontent.trim();
    }

    public Integer getInvestigatorid() {
        return investigatorid;
    }

    public void setInvestigatorid(Integer investigatorid) {
        this.investigatorid = investigatorid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}