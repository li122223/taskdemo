package com.lzj.taskdemo.controller;

import com.lzj.taskdemo.entity.User;
import com.lzj.taskdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        User user = loginService.login(username,password);
        if (user!=null){
            session.setAttribute("loginUser",user);


            return "main";
        }else{
            model.addAttribute("error","用户名和密码错误");
            return "login";
        }
    }


    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("loginUser",null);
        return "login";

    }




}
