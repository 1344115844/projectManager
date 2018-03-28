package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class AttendConference implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private String conferencename;

    private String papertitle;

    private Date time;

    private String place;

    private String hostunit;

    private String conferencecategory;

    private Integer attendid;

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

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename == null ? null : conferencename.trim();
    }

    public String getPapertitle() {
        return papertitle;
    }

    public void setPapertitle(String papertitle) {
        this.papertitle = papertitle == null ? null : papertitle.trim();
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

    public String getHostunit() {
        return hostunit;
    }

    public void setHostunit(String hostunit) {
        this.hostunit = hostunit == null ? null : hostunit.trim();
    }

    public String getConferencecategory() {
        return conferencecategory;
    }

    public void setConferencecategory(String conferencecategory) {
        this.conferencecategory = conferencecategory == null ? null : conferencecategory.trim();
    }

    public Integer getAttendid() {
        return attendid;
    }

    public void setAttendid(Integer attendid) {
        this.attendid = attendid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}