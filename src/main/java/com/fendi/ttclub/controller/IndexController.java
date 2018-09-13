package com.fendi.ttclub.controller;

import com.fendi.ttclub.constant.TTClubConstant;
import com.fendi.ttclub.entity.User;
import com.fendi.ttclub.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user,HttpSession session,Model model){
        LOGGER.info("登录系统----------登录用户名："+user.getLoginName()+",密码："+user.getPassword());
        User loginUser = userService.getUserByName(user);
        if(loginUser!=null){
            session.setAttribute(TTClubConstant.LOGIN_USER, loginUser);
            model.addAttribute("user", loginUser);
            return "index";
        }else{
            model.addAttribute("message", "用户名或密码错误！");
            return "login";
        }
    }

}
