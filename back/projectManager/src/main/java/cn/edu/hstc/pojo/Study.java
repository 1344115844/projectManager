package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Study implements Serializable {
    private Integer stuId;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private Date beginTime;

    private Date overTime;

    private String school;

    private String studyContent;

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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getStudyContent() {
        return studyContent;
    }

    public void setStudyContent(String studyContent) {
        this.studyContent = studyContent == null ? null : studyContent.trim();
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