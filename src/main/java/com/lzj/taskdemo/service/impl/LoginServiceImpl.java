package com.lzj.taskdemo.service.impl;

import com.lzj.taskdemo.dao.LoginRepository;
import com.lzj.taskdemo.entity.User;
import com.lzj.taskdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
        @Autowired
    LoginRepository loginRepository;
    @Override
    public User login(String username, String password) {
        User user = loginRepository.findUserByUsername(username);
        if (user!=null && user.getPassword().equals(password)){
            return user;
        }else {
            return null;
        }
    }
}
