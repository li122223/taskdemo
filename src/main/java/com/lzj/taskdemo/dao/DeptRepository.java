package com.lzj.taskdemo.dao;

import com.lzj.taskdemo.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept,String> {


    public List<Dept> findAll();
   /* public void deleteById(String id);*/

    /*@Query("select dept_name from tb_dept where id = ?1 ")
    public String selectNameById(String id);*/

/*    Dept findById(Integer id);*/
@Modifying
@Transactional
@Query("delete from tb_dept td where td.id =?1")
void deleteById(String id);



}
