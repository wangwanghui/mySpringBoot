package com.example.demo.control;

import com.example.demo.entity.User;
import com.example.demo.service.Userservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class control {
    @RequestMapping("/hi")
    public String wellcom(Model model){
        model.addAttribute("index","首页Hello world");
        return "/index";
    }
    /**
     * 跳转到添加用户信息
     * */
    @RequestMapping("/user/add")
    public String add(){
        return "/user/add";
    }
    /**
     * 跳转到更新用户信息
     * */
    @RequestMapping("/user/update")
    public String update(){
        return "/user/update";
    }
    /**
     * 跳转到登陆界面
     * */
    @RequestMapping("/tologin")
    public String tologin(){
        return "/login";
    }

    @RequestMapping("/unauth")
    public  String  unauth(){
            return "/unauth";
    }


    /**
     * 登陆+shiro处理逻辑
     * */
    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest re ){
        /**
         * 使用Shiro编写认证操作
         * 1、获取Subject
         *      Subject subject= SecurityUtils.getSubject();
         * 2、封装用户数据
         *      UsernamePasswordToken token=new UsernamePasswordToken(name,password);
         * 3、执行登陆方法
         *      subject.login(token);
         * */
        model.addAttribute("index","首页Hello world");
        String username=re.getParameter("username");
        String password=re.getParameter("password");
        Subject subject= SecurityUtils.getSubject();
        System.out.println("mingzi"+username+"mimawei"+password);

        //这里使用import org.apache.shiro.crypto.hash.Md5Hash; shiro自带的MD5加密密码(因为数据库中的密码是md5的)，下面也有java代码将字符串进行md5加密代码

        //这里加密其实有很多方法如下：

        //使用MD5加密算法加密
        //Md5Hash md5=new Md5Hash("xxx");
        //System.out.println("zyy233215==="+md5.toString());
        //加盐
        //md5=new Md5Hash("xxx","sxt");
        //System.out.println("zyy233215==="+md5.toString());
        //迭代
        //md5=new Md5Hash("xxx","sxt",2);
        //System.out.println("zyy233215==="+md5.toString());

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            //登陆成功
            return "/index";
        }catch (UnknownAccountException e){
            //登陆失败：用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "/login";
        }
    }
}
