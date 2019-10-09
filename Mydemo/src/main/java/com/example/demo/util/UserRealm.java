package com.example.demo.util;

import com.example.demo.entity.CLogin;
import com.example.demo.service.CLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自动与i的Realm
 */

public class UserRealm extends AuthorizingRealm {
    @Autowired
    CLoginService cLoginService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("=-----执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加授权字符串 这个字符串和加上权限的字符串一致
        //info.addStringPermission("user:add");
        //到数据库查询当前用户的授权的字符串
        Subject subject = SecurityUtils.getSubject();
        CLogin cLogin = (CLogin) subject.getPrincipal();//这里的CLogin对象是登陆的时候传过来的
        CLogin dbclogin = cLoginService.FindUserLogin(cLogin.getUsername());
        info.addStringPermission(dbclogin.getPerms());
        System.out.println("dbclogin.getPerms()" + dbclogin.getPerms());
        return info;

    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //编写shiro判断逻辑，判断用户名和密码
        //1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token);
        CLogin cLogin = cLoginService.FindUserLogin(token.getUsername());

        System.out.println("=====" + cLogin.getPassword());
        if (cLogin == null) {
            //用户名不存在
            return null;//shiro底层抛出UnknownAccountException
        }
        //2、判断密码 三个参数：1、返回给subject.login(token);方法的参数  2、数据库中的密码 3、shiro的名字
        return new SimpleAuthenticationInfo(cLogin, cLogin.getPassword(), "UserRealm");

    }
}