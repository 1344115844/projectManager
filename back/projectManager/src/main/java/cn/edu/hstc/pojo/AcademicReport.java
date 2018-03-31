package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class AcademicReport implements Serializable {
    private Integer repId;

    private Date createTime;

    private Date updateTime;

    private Integer delete;

    private String reportTitle;

    private Date beginTime;

    private Date overTime;

    private String hostUnit;

    private String hostPlace;

    private Integer attendNum;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
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

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle == null ? null : reportTitle.trim();
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

    public String getHostUnit() {
        return hostUnit;
    }

    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit == null ? null : hostUnit.trim();
    }

    public String getHostPlace() {
        return hostPlace;
    }

    public void setHostPlace(String hostPlace) {
        this.hostPlace = hostPlace == null ? null : hostPlace.trim();
    }

    public Integer getAttendNum() {
        return attendNum;
    }

    public void setAttendNum(Integer attendNum) {
        this.attendNum = attendNum;
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