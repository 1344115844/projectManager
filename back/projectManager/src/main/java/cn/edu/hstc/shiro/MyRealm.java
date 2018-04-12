package cn.edu.hstc.shiro;


import cn.edu.hstc.pojo.User;
import cn.edu.hstc.service.UserService;
import cn.edu.hstc.util.MD5Util;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author Veng Su 1344114844@qq.com
 * @date 2018/4/12 9:40
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userServiceImpl;

    //为当前登录成功的用户授予权限和角色，已经登录成功了。
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=(String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userServiceImpl.getRoles(username));
        authorizationInfo.setStringPermissions(userServiceImpl.getPermissions(username));
        return authorizationInfo;
    }


    //验证当前登录的用户，获取认证信息。
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String) token.getPrincipal();//获取用户名
        User user=userServiceImpl.getByUsername(username);
        if(user!=null){
            AuthenticationInfo authcInfo =new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),"myRealm");
            return authcInfo;
        }else{
            return null;
        }
    }
}
