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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录与注销
 */

@Controller
public class LoginController {

    //注入userService
    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    //跳转到登录页面
    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "login";
    }

    //登录
    @RequestMapping(value = "/login")
    public String login(String userid, String password, Model model,HttpSession session,
                        WordDefined defined, LogUtil logUtil, CommonDate date, NetUtil netUtil, HttpServletRequest request){
        //根据账号查找用户
        User existUser = userService.selectUserByUserid(userid);
        if(existUser == null){  //没查到用户
            model.addAttribute("error",defined.LOGIN_USERID_ERROR);
            return "forward:/loginPage";
        }else {
            if(!existUser.getPassword().equals(password)){  //查到用户，但是密码不对
                model.addAttribute("error",defined.LOGIN_PASSWORD_ERROR);
                return "forward:/loginPage";
            }else {
                if(existUser.getStatus() != 1){             //查到用户，密码也对，但是账号状态不对
                    model.addAttribute("error",defined.LOGIN_USERID_DISABLED);
                    return "forward:/loginPage";
                }else{                                      //登录成功
                    logService.insert(logUtil.setLog(userid,date.getTime24(),       //插入系统日志
                            defined.LOG_TYPE_LOGIN,defined.LOG_DETAIL_USER_LOGIN,netUtil.getIpAddress(request)));
                    session.setAttribute("existUser",existUser);                //将查到的用户信息保存到session域中
                    existUser.setLasttime(date.getTime24());                        //更新最后登陆时间
                    userService.update(existUser);                                 //更新用户
                    model.addAttribute("message",defined.LOGIN_SUCCESS);
                    return "index";
                }
            }
        }
    }

    //注销（退出登录）
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model, WordDefined defined){
        session.removeAttribute("existUser");
        model.addAttribute("message",defined.LOGOUT_SUCCESS);
        return "redirect:/loginPage";
    }

}
