package com.lzj.taskdemo.dao;

import com.lzj.taskdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,String> {


    public <S extends Employee> S save(S s);
    public List<Employee> findAll();
   /* public List<Employee> findByDept_name(String deptname);*/

    @Query(value = "select * from tb_employee where dept_name = ?1",nativeQuery = true)
    public List<Employee> find(String name);







    @Modifying
    @Transactional
    @Query("delete from tb_employee te where te.employee_id =?1 ")
    void deleteById(String id);



}


