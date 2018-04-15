package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Patent implements Serializable {
    private Integer tentId;

    private Integer deleted;

    private Date updateTime;

    private Date createTime;

    private String patentTame;

    private String patentRank;

    private String patentForm;

    private String authority;

    private String registrationEnterprise;

    private String patentNum;

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

    public Integer getTentId() {
        return tentId;
    }

    public void setTentId(Integer tentId) {
        this.tentId = tentId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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

    public String getPatentTame() {
        return patentTame;
    }

    public void setPatentTame(String patentTame) {
        this.patentTame = patentTame == null ? null : patentTame.trim();
    }

    public String getPatentRank() {
        return patentRank;
    }

    public void setPatentRank(String patentRank) {
        this.patentRank = patentRank == null ? null : patentRank.trim();
    }

    public String getPatentForm() {
        return patentForm;
    }

    public void setPatentForm(String patentForm) {
        this.patentForm = patentForm == null ? null : patentForm.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    public String getRegistrationEnterprise() {
        return registrationEnterprise;
    }

    public void setRegistrationEnterprise(String registrationEnterprise) {
        this.registrationEnterprise = registrationEnterprise == null ? null : registrationEnterprise.trim();
    }

    public String getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(String patentNum) {
        this.patentNum = patentNum;
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