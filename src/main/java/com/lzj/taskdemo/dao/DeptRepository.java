package com.lzj.taskdemo.dao;

import com.lzj.taskdemo.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept,String> {


    public List<Dept> findAll();
    public void deleteById(String id);

    /*@Query("select dept_name from tb_dept where id = ?1 ")
    public String selectNameById(String id);*/

/*    Dept findById(Integer id);*/
}
