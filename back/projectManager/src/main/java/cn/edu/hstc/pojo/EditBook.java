package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.Date;

public class EditBook implements Serializable {
    private Integer editId;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private String bookName;

    private String editRank;

    private String isbn;

    private String publishUnit;

    private Date publishTime;

    private Integer byteNum;

    private Integer userId;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getEditId() {
        return editId;
    }

    public void setEditId(Integer editId) {
        this.editId = editId;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getEditRank() {
        return editRank;
    }

    public void setEditRank(String editRank) {
        this.editRank = editRank == null ? null : editRank.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getPublishUnit() {
        return publishUnit;
    }

    public void setPublishUnit(String publishUnit) {
        this.publishUnit = publishUnit == null ? null : publishUnit.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getByteNum() {
        return byteNum;
    }

    public void setByteNum(Integer byteNum) {
        this.byteNum = byteNum;
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