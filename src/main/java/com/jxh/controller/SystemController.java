package com.jxh.controller;

import com.jxh.constant.SystemConstant;
import com.jxh.domain.Admin;
import com.jxh.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author meizh
 * 系统接口
 */
@Controller
public class SystemController {



    @Autowired
    private IAdminService adminService;

    /**
     * 跳转系统首页
     */
    @GetMapping("/index")
    public String goIndex() {
        return "index";
    }

    /**
     * 跳转登录页
     */
    @GetMapping("/login")
    public String goLogin() {
        return "login";
    }


    /**
     * 登录功能
     */
    @PostMapping ("/login")
    public String login(Admin admin, Model model, HttpSession session) {
        try {
            Admin dbAdmin = adminService.login(admin);
            session.setAttribute(SystemConstant.ADMIN_IN_SESSION, dbAdmin);
            System.out.println(dbAdmin.getNickname());
            return "index";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "login";
        }
    }

    /**
     * 注销
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    /**
     * 跳转修改密码页
     */
    @GetMapping("/pwd")
    public String gopwd() {
        return "password";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatePwd")
    public String updatePwd(Admin admin){
        adminService.updateAdmin(admin);
        return "login";
    }

}
