package com.lzj.taskdemo.dao;

import com.lzj.taskdemo.entity.Employee;
import com.lzj.taskdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {

    /*@Modifying
    @Transactional
    @Query(value = "update User set password = ?1",nativeQuery = true)
    public void updatepsw(User user);*/

    @Override
    <S extends User> S save(S s);
}
