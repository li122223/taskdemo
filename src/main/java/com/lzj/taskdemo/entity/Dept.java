package com.lzj.taskdemo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_dept")
@Getter
@Setter
public class Dept implements Serializable {

    @Id
    private String id;
    private String DeptName;
    private String address;


    /*@ManyToOne()
    private Employee employee;*/


    /*@OneToMany(fetch = FetchType.LAZY
    ,targetEntity = Employee.class)
    private Set<Employee> employees = new HashSet<>();*/
}
