package cn.edu.hstc.pojo;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer perId;

    private String perName;

    private Role role;

    private static final long serialVersionUID = 1L;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}