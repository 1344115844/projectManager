package cn.edu.hstc.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/6 21:31
 */
public class Role implements Serializable {
    private int roleId;
    private String roleName;
    private List<Permission> permissions;
    private static final long serialVersionUID = 1L;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
