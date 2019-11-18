package com.lzj.taskdemo.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "tb_employee")
@Getter
@Setter
@ToString
public class Employee {


    @Id
    private String employee_id;
    private String  employee_name;
    private String address;
    private String employee_job;

   /* @ManyToOne(fetch = FetchType.LAZY, targetEntity = Dept.class)
    @JoinColumn(name = "id")*/


    private String dept_name;
    private String employee_type;




}
