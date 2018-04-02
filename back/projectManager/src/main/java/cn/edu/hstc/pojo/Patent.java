package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Patent implements Serializable {
    private Integer pId;

    private Integer deleted;

    private Date updateTime;

    private Date createTime;

    private String patentTame;

    private String patentRank;

    private String patentForm;

    private String authority;

    private String registrationEnterprise;

    private Integer patentNum;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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

    public Integer getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(Integer patentNum) {
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