package com.lzj.taskdemo.dao;

import com.lzj.taskdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
