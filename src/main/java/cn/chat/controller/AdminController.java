package cn.chat.controller;

import cn.chat.entity.Admin;
import cn.chat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 管理员的controller
 */

@Controller
public class AdminController {

    //使用注解方式注入service对象
    @Autowired
    private AdminService adminService;

    //跳转到登录页面
    @RequestMapping(value = "test")
    public String test(Model model){
        List<Admin> adminList = adminService.findAll();
        model.addAttribute("adminList",adminList);
        return "test";
    }

    //跳转到主页
    @RequestMapping(value="index")
    public String index(){
        return "login/index";
    }

    //注销
    @RequestMapping("over")
    public String over(HttpSession session){
        //移除session域中的existAdmin
        session.removeAttribute("existAdmin");
        //重定向到登录页面
        return "redirect:login.action";
    }

}
