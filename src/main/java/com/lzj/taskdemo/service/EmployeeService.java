package com.lzj.taskdemo.service;

import com.lzj.taskdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee employee);
    public List<Employee> findByDeptName(String name);
    public List<Employee> getAll();
    public void deleteById(String id);

    /*Employee getById(String id);*/
}
