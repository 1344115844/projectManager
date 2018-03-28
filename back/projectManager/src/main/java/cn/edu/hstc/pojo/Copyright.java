package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Copyright implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private String rightname;

    private String rank;

    private Date awardtime;

    private Integer rightnum;

    private Integer memberid;

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

    public String getRightname() {
        return rightname;
    }

    public void setRightname(String rightname) {
        this.rightname = rightname == null ? null : rightname.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public Date getAwardtime() {
        return awardtime;
    }

    public void setAwardtime(Date awardtime) {
        this.awardtime = awardtime;
    }

    public Integer getRightnum() {
        return rightnum;
    }

    public void setRightnum(Integer rightnum) {
        this.rightnum = rightnum;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}