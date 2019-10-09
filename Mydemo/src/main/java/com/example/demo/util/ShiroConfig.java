package com.example.demo.util;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**添加Shiro内置过滤器，可以实现权限相关的拦截器
         * 常用的过滤器
         *      anon：无需认证(登陆)即可访问
         *      authc：必须认证才可以访问 (登陆)
         *      user：如果使用rememberMe的功能可以直接访问
         *      perms：该资源必须得到资源权限才可以访问
         *      role：该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        /**
         * 添加拦截的资源路径，以及权限
         * 默认拦截后跳转到login.jsp
         * */
        //1、通过url设置user目录下的网页需要授权访问
        /*filterMap.put("/user/add", "perms[0]");
        filterMap.put("/user/update", "perms[1]");
*/
        //设置未授权的界面
        // * 2、方式二 将url前面都添加上user，这样就可以使用下面的方法进行拦截* */
        filterMap.put("/user/*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //修改默认的拦截后跳转的登陆界面
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}