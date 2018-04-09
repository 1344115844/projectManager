package cn.edu.hstc.interceptor;


import cn.edu.hstc.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/3/28 8:16
 * 说明：uri拦截器
 */
public class SessionInterceptor implements HandlerInterceptor{

    /*
     *@author suveng
     *@date 2018/3/29 21:03
     *@param [request, response, o]
     *@return boolean
     *方法作用：拦截所有请求，除了login接口，访问其他接口时，必须先登录设置session后，才能访问。
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if((uri.indexOf("login")>=0)||(uri.indexOf("error")>=0)||(uri.indexOf("static")>=0)||(uri.indexOf("lib")>=0)||(uri.indexOf("myjs")>=0)||(uri.indexOf("uploads")>=0)||(uri.indexOf("workflow")>=0)){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if(user!=null){
            return true;
        }
//        转发到登录
        request.getRequestDispatcher("/user/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
