package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Speech implements Serializable {
    private Integer speechId;

    private Date createTime;

    private Date updateTime;

    private Integer delete;

    private Date inviteTime;

    private Date beginTime;

    private Date overTime;

    private String speechForm;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getSpeechId() {
        return speechId;
    }

    public void setSpeechId(Integer speechId) {
        this.speechId = speechId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getSpeechForm() {
        return speechForm;
    }

    public void setSpeechForm(String speechForm) {
        this.speechForm = speechForm == null ? null : speechForm.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}