package cn.edu.hstc.vo;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/12 17:08
 */
public class AddAdmin {
    private String name;
    private String username;
    private String password;
    private int roleId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
