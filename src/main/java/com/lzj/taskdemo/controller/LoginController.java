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
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        User user = loginService.login(username, password);
        if (user != null) {
            if (user.getRole().equals("admin")) {
                session.setAttribute("loginUser", user);
                return "admin_main";
            } else {
                session.setAttribute("loginUser", user);
                return "main";
            }
        } else {
            return "login";
        }
    }



    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("loginUser",null);
        return "login";

    }




}
