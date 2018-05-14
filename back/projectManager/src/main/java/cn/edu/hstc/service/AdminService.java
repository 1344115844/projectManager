package cn.edu.hstc.service;

import cn.edu.hstc.vo.AddAdmin;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/5/12 17:13
 */

public interface AdminService {
    void addRole(AddAdmin addAdmin);

    void del(int userId);
}
