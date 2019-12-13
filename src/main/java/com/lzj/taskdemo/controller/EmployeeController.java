package com.lzj.taskdemo.controller;

import com.lzj.taskdemo.dao.DeptRepository;
import com.lzj.taskdemo.dao.EmployeeRepository;
import com.lzj.taskdemo.entity.Dept;
import com.lzj.taskdemo.entity.Employee;
import com.lzj.taskdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DeptRepository deptRepository;


    @RequestMapping("/to_main")
    public String main(){
        return "main";
    }

    @RequestMapping("/to_admin_main")
    public String main1(){
        return "admin_main";
    }

    @GetMapping("/list")
    public String list(Model model){
        Collection<Employee> employees = employeeService.getAll();

        model.addAttribute("emps",employees);


        return "employee_list";}


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model, Map<String,Object> map){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Dept> departments = deptRepository.findAll();
        model.addAttribute("depts",departments);

       map.put("employee",new Employee());


        return "employee_add";
    }





    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面employee_type = null

        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeService.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/list";
    }




        @RequestMapping("/emp/{id}")
          public String delete(@PathVariable("id") String id){
             employeeService.deleteById(id);
             return "redirect:/list";
        }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
        Employee employee = employeeRepository.getOne(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表

        Collection<Dept> departments = deptRepository.findAll();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "employee_edit";
    }

    //员工修改；需要提交员工id；
    @RequestMapping("/update")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employee.setEmployee_id(employee.getEmployee_id());
        employeeRepository.save(employee);
        return "redirect:/list";
    }


    @RequestMapping("search")
    public String search(@RequestParam("dept_name") String name,Model model){
        Collection<Employee> employees = employeeRepository.find(name);
        model.addAttribute("Emp",employees);
        return "employee_search";
    }
}
