package cn.edu.hstc.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/31 19:18
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("/add/member")
    public String showAdd(){
        return "member-list";
    }
}
