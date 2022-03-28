package com.mindtree.employee.controller;

import com.mindtree.employee.service.EmployeeService;
import com.mindtree.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee (@RequestBody Employee employee) {
        Boolean emp = employeeService.getEmployee(employee);
        if(!emp) {
            employeeService.saveEmployee(employee);
            return new ResponseEntity<String>("Employee saved", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Employee already exists in the database", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/updateSalary/{id}/{salary}")
    public int updateEmployee(@PathVariable ("salary") int salary, @PathVariable ("id") Long id){
        return employeeService.updateEmployeeSalary(id, salary);
    }
}
