package com.lzj.taskdemo.service;

import com.lzj.taskdemo.entity.User;
import org.springframework.stereotype.Service;


public interface LoginService {
    User login(String username,String password);
}
