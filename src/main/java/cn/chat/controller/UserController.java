package cn.chat.controller;

import cn.chat.entity.User;
import cn.chat.service.LogService;
import cn.chat.service.UserService;
import cn.chat.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    //修改密码
    @RequestMapping(value = "{userid}/pass")
    public String changePassword(@PathVariable("userid") String userid, String oldpass, String newpass, Model model,
                                 NetUtil netUtil, LogUtil logUtil, CommonDate date, WordDefined defined, HttpServletRequest request){
        User existUser = userService.selectUserByUserid(userid);
        if(oldpass.equals(existUser.getPassword())){
            existUser.setPassword(newpass);
            boolean flag = userService.update(existUser);
            if(flag){
                logService.insert(logUtil.setLog(userid, date.getTime24(), defined.LOG_TYPE_UPDATE, defined.LOG_DETAIL_UPDATE_PASSWORD, netUtil.getIpAddress(request)));
                model.addAttribute("message", "["+existUser.getUserid()+"]密码更新成功!");
            }else{
                model.addAttribute("error", "["+existUser.getUserid()+"]密码更新失败!");
                //失败页面没做
            }
        }else{
            model.addAttribute("error", "密码错误!");
            //失败页面没做
        }
        return "redirect:/user/{userid}/information";
    }

    //头像上传
    @RequestMapping(value = "{userid}/upload")
    public String upload(@PathVariable("userid") String userid, MultipartFile file, HttpServletRequest request, UploadUtil uploadUtil,
                         Model model, NetUtil netUtil, LogUtil logUtil, CommonDate date, WordDefined defined){
        try{
            String fileurl = uploadUtil.upload(request, "upload", userid);
             User existUser = userService.selectUserByUserid(userid);
            existUser.setProfilehead(fileurl);
            boolean flag = userService.update(existUser);
            if(flag){
                logService.insert(logUtil.setLog(userid, date.getTime24(), defined.LOG_TYPE_UPDATE, defined.LOG_DETAIL_UPDATE_PROFILEHEAD, netUtil.getIpAddress(request)));
                model.addAttribute("message", "["+userid+"]头像更新成功!");
            }else{
                model.addAttribute("error", "["+userid+"]头像更新失败!");
            }
        } catch (Exception e){
            model.addAttribute("error", "["+userid+"]头像更新失败!");
        }
        return "redirect:/user/{userid}/information";
    }

    //进入聊天室页面
    @RequestMapping(value = "{userid}/chatPage")
    public String chatPage(@PathVariable("userid") String userid, HttpSession session, Model model){
        User existUser = userService.selectUserByUserid(userid);
        session.setAttribute("existUser",existUser);
//        model.addAttribute("userid",userid);
        session.setAttribute("userid",userid);
        return "chat";
    }

}
