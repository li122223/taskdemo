package com.lzj.taskdemo.controller;

import com.lzj.taskdemo.dao.DeptRepository;
import com.lzj.taskdemo.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class DeptController {

    @Autowired
    DeptRepository deptRepository;


    @GetMapping("dept_list")
    public String list(Model model){
        /*Collection<Dept> depts = deptRepository.findAll();
        map.put()*/
        Collection<Dept> departments = deptRepository.findAll();
        model.addAttribute("depts",departments);
        return "dept_list";
    }



}
