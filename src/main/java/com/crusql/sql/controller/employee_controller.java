package com.crusql.sql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crusql.sql.model.Employee;
import com.crusql.sql.repository.employee_repo;


@RestController
@RequestMapping(value = "/employee")
public class employee_controller {

    @Autowired
    employee_repo employerepo;

    //testing if port works !
    @GetMapping("/test")
    public String test(){
        return "This Port Works !";
    }

    //so basically takes in 
    @PostMapping("/add")
    Employee addEmployee(@RequestBody Employee employee){
        employerepo.save(employee);
        return employee;
    }
    
    @GetMapping("/getall")
    List<Employee> getEmployee(){
        List<Employee> employee = employerepo.findAll();
        return employee;
    }
}
