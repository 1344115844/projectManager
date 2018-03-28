package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class AcademicReport implements Serializable {
    private Integer id;

    private Date createtime;

    private Date updatetime;

    private Date deletetime;

    private String reporttitle;

    private Date begintime;

    private Date overtime;

    private String hostunit;

    private String hostplace;

    private Integer attendnum;

    private Integer reporterid;

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

    public String getReporttitle() {
        return reporttitle;
    }

    public void setReporttitle(String reporttitle) {
        this.reporttitle = reporttitle == null ? null : reporttitle.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public String getHostunit() {
        return hostunit;
    }

    public void setHostunit(String hostunit) {
        this.hostunit = hostunit == null ? null : hostunit.trim();
    }

    public String getHostplace() {
        return hostplace;
    }

    public void setHostplace(String hostplace) {
        this.hostplace = hostplace == null ? null : hostplace.trim();
    }

    public Integer getAttendnum() {
        return attendnum;
    }

    public void setAttendnum(Integer attendnum) {
        this.attendnum = attendnum;
    }

    public Integer getReporterid() {
        return reporterid;
    }

    public void setReporterid(Integer reporterid) {
        this.reporterid = reporterid;
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }
}