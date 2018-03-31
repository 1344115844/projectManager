package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Investigate implements Serializable {
    private Integer invId;

    private Integer delete;

    private Date updateTime;

    private Date createTime;

    private Date beginTime;

    private Date overTime;

    private String investigatePlace;

    private String investigateContent;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getInvestigatePlace() {
        return investigatePlace;
    }

    public void setInvestigatePlace(String investigatePlace) {
        this.investigatePlace = investigatePlace == null ? null : investigatePlace.trim();
    }

    public String getInvestigateContent() {
        return investigateContent;
    }

    public void setInvestigateContent(String investigateContent) {
        this.investigateContent = investigateContent == null ? null : investigateContent.trim();
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