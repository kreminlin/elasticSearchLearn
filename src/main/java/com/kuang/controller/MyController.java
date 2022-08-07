package com.kuang.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    private static final transient Logger log = LoggerFactory.getLogger(MyController.class);

    @RequestMapping({"/", "/index"})
    public String toIndex(Model model) {
        return "index.html";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add.html";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update.html";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login.html";
    }

    @RequestMapping("/login")
    public String toLogin(String username, String password, Model model) {
        //获取当前登录角色
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        //执行登录的方法，如果没有异常就验证通过了
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException uae) {
            log.info("There is no user with username of " + token.getPrincipal());
            model.addAttribute("msg", "用户不存在");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (LockedAccountException lae) {
            log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
            model.addAttribute("msg", "用户被锁");
            return "login";
        }
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}
