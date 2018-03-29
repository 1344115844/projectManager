package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Investigate implements Serializable {
    private Integer id;

    private Integer delete;

    private Date updateTime;

    private Date createTime;

    private Date beginTime;

    private Date overTime;

    private String investigatePlace;

    private String investigateContent;

    private Integer memberId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}