package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Academic implements Serializable {
    private Integer acadId;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private String thesisName;

    private String novon;

    private String releasingCode;

    private String publicationLevel;

    private String periodical;

    private String publishJournals;

    private String collectionSituation;

    private String authorRank;

    private String category;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getAcadId() {
        return acadId;
    }

    public void setAcadId(Integer acadId) {
        this.acadId = acadId;
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

    public void setDelete(Integer delete) {
        this.deleted = delete;
    }

    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName == null ? null : thesisName.trim();
    }

    public String getNovon() {
        return novon;
    }

    public void setNovon(String novon) {
        this.novon = novon == null ? null : novon.trim();
    }

    public String getReleasingCode() {
        return releasingCode;
    }

    public void setReleasingCode(String releasingCode) {
        this.releasingCode = releasingCode == null ? null : releasingCode.trim();
    }

    public String getPublicationLevel() {
        return publicationLevel;
    }

    public void setPublicationLevel(String publicationLevel) {
        this.publicationLevel = publicationLevel == null ? null : publicationLevel.trim();
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical == null ? null : periodical.trim();
    }

    public String getPublishJournals() {
        return publishJournals;
    }

    public void setPublishJournals(String publishJournals) {
        this.publishJournals = publishJournals == null ? null : publishJournals.trim();
    }

    public String getCollectionSituation() {
        return collectionSituation;
    }

    public void setCollectionSituation(String collectionSituation) {
        this.collectionSituation = collectionSituation == null ? null : collectionSituation.trim();
    }

    public String getAuthorRank() {
        return authorRank;
    }

    public void setAuthorRank(String authorRank) {
        this.authorRank = authorRank == null ? null : authorRank.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
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