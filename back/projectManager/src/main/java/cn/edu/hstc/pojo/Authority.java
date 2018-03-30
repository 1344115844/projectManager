package cn.edu.hstc.pojo;

import java.io.Serializable;

public class Authority implements Serializable {
    private Integer memberId;

    private Integer register;

    private static final long serialVersionUID = 1L;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }
}