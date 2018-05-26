package cn.chat.controller;

import cn.chat.entity.User;
import cn.chat.service.LogService;
import cn.chat.service.UserService;
import cn.chat.util.CommonDate;
import cn.chat.util.LogUtil;
import cn.chat.util.NetUtil;
import cn.chat.util.WordDefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户的控制器
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    //用户信息的显示(根据userid)
    @RequestMapping(value = "{userid}/information")
    public String information( @PathVariable("userid") String userid, Model model){
        User existUser = userService.selectUserByUserid(userid);
        model.addAttribute("existUser",existUser);
        return "information";
    }

    //显示个人信息编辑页面
    @RequestMapping(value = "{userid}/editPage")
    public String editPage(@PathVariable("userid") String userid, Model model){
        User existUser = userService.selectUserByUserid(userid);
        model.addAttribute("existUser",existUser);
        return "info-setting";
    }

    //更新个人信息
    @RequestMapping(value = "{userid}/update")
    public String update(@PathVariable("userid") String userid,User user,Model model, NetUtil netUtil, LogUtil logUtil,
                         CommonDate date, WordDefined defined, HttpServletRequest request){
        boolean flag = userService.update(user);
        if(flag){
            logService.insert(logUtil.setLog(user.getUserid(), date.getTime24(),
                    defined.LOG_TYPE_UPDATE, defined.LOG_DETAIL_UPDATE_PROFILE, netUtil.getIpAddress(request)));
            model.addAttribute("message", "["+user.getUserid()+"]资料更新成功!");
        }else {
            model.addAttribute("error", "["+user.getUserid()+"]资料更新失败!");
        }
        return "redirect:/user/{userid}/information";
    }

}
