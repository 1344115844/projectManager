package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class AttendConference implements Serializable {
    private Integer confId;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private String conferenceName;

    private String paperTitle;

    private Date time;

    private String place;

    private String hostUnit;

    private String conferenceCategory;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    private Filepath filepath;

    public Filepath getFilepath() {
        return filepath;
    }

    public void setFilepath(Filepath filepath) {
        this.filepath = filepath;
    }

    public Integer getConfId() {
        return confId;
    }

    public void setConfId(Integer confId) {
        this.confId = confId;
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
        return deleted;
    }

    public void setDelete(Integer deleted) {
        this.deleted = deleted;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName == null ? null : conferenceName.trim();
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle == null ? null : paperTitle.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getHostUnit() {
        return hostUnit;
    }

    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit == null ? null : hostUnit.trim();
    }

    public String getConferenceCategory() {
        return conferenceCategory;
    }

    public void setConferenceCategory(String conferenceCategory) {
        this.conferenceCategory = conferenceCategory == null ? null : conferenceCategory.trim();
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