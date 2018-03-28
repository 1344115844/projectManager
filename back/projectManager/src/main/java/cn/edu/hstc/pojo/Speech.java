package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Speech implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private Date invitetime;

    private Date begintime;

    private Date overtime;

    private String speechform;

    private Integer speakerid;

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

    public Date getInvitetime() {
        return invitetime;
    }

    public void setInvitetime(Date invitetime) {
        this.invitetime = invitetime;
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

    public String getSpeechform() {
        return speechform;
    }

    public void setSpeechform(String speechform) {
        this.speechform = speechform == null ? null : speechform.trim();
    }

    public Integer getSpeakerid() {
        return speakerid;
    }

    public void setSpeakerid(Integer speakerid) {
        this.speakerid = speakerid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}