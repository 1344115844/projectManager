package cn.edu.hstc.pojo;

import java.io.Serializable;

public class Authority implements Serializable {
    private Integer userId;

    private Integer register;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }
}