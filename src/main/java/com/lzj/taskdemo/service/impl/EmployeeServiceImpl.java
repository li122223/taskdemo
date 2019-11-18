package com.lzj.taskdemo.service.impl;

import com.lzj.taskdemo.dao.DeptRepository;
import com.lzj.taskdemo.dao.EmployeeRepository;

import com.lzj.taskdemo.entity.Employee;
import com.lzj.taskdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DeptRepository deptRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByDeptName(String name) {
        return employeeRepository.find(name);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }


    public void deleteById(String id) {
        employeeRepository.deleteById(id);

  }

  /*  @Override
    public Employee getById(String id) {
        return (Employee) employeeRepository.findByEmployee_id(id);
    }*/
}
