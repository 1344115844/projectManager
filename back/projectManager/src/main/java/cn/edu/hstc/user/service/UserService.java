package cn.edu.hstc.user.service;

import cn.edu.hstc.user.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/27 9:25
 */

public interface UserService {

    User findUserByUsername();
}
