package com.lzj.taskdemo.controller;

import com.lzj.taskdemo.dao.DeptRepository;
import com.lzj.taskdemo.entity.Dept;
import com.lzj.taskdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class DeptController {

    @Autowired
    DeptRepository deptRepository;


    @GetMapping("/dept_list")
    public String list(Model model){
        /*Collection<Dept> depts = deptRepository.findAll();
        map.put()*/
        Collection<Dept> departments = deptRepository.findAll();
        model.addAttribute("depts",departments);
        return "dept_list";
    }

    @GetMapping("/dept_add")
    public String add(ModelMap map){
        map.put("dept",new Dept());
        return "dept_add";
    }

    @PostMapping("/AddDept")
    public String Add(Dept dept){
        System.out.println("saved dept:"+dept);
        deptRepository.save(dept);
        return "redirect:dept_list";
    }

    @GetMapping("/dept/{id}")
    public String update(@PathVariable("id") String id,Model model){
        Dept dept = deptRepository.getOne(id);
        model.addAttribute("depts",dept);
        return "dept_edit";


    }

    @PostMapping("dept_update")
    public String Update(Dept dept){

        dept.setId(dept.getId());
        deptRepository.save(dept);
        return "redirect:dept_list";
    }
    @RequestMapping("/dept/{id}")
    public String delete(@PathVariable("id") String id){
        deptRepository.deleteById(id);
        return "redirect:/dept_list";
    }





}
