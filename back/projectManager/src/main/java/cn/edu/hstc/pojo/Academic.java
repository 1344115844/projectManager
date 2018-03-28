package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Academic implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private String thesisname;

    private String novon;

    private String releasingcode;

    private String publicationlevel;

    private String periodical;

    private String publishjournals;

    private String collectionsituation;

    private String authorrank;

    private String category;

    private Integer authorid;

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

    public String getThesisname() {
        return thesisname;
    }

    public void setThesisname(String thesisname) {
        this.thesisname = thesisname == null ? null : thesisname.trim();
    }

    public String getNovon() {
        return novon;
    }

    public void setNovon(String novon) {
        this.novon = novon == null ? null : novon.trim();
    }

    public String getReleasingcode() {
        return releasingcode;
    }

    public void setReleasingcode(String releasingcode) {
        this.releasingcode = releasingcode == null ? null : releasingcode.trim();
    }

    public String getPublicationlevel() {
        return publicationlevel;
    }

    public void setPublicationlevel(String publicationlevel) {
        this.publicationlevel = publicationlevel == null ? null : publicationlevel.trim();
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical == null ? null : periodical.trim();
    }

    public String getPublishjournals() {
        return publishjournals;
    }

    public void setPublishjournals(String publishjournals) {
        this.publishjournals = publishjournals == null ? null : publishjournals.trim();
    }

    public String getCollectionsituation() {
        return collectionsituation;
    }

    public void setCollectionsituation(String collectionsituation) {
        this.collectionsituation = collectionsituation == null ? null : collectionsituation.trim();
    }

    public String getAuthorrank() {
        return authorrank;
    }

    public void setAuthorrank(String authorrank) {
        this.authorrank = authorrank == null ? null : authorrank.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}