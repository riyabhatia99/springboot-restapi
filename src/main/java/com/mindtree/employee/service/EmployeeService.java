package com.mindtree.employee.service;

import com.mindtree.employee.repo.EmployeeRepo;
import com.mindtree.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public boolean getEmployee(Employee employee) {
        return employeeRepo.existsById(employee.getId());
    }

    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
       return employeeRepo.findByOrderBySalaryDescNameAsc();
    }

    public int updateEmployeeSalary(Long id, int salary) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if(emp.isPresent()) {
            Employee employee = new Employee();
            employee.setSalary(salary);
            employee.setId(emp.get().getId());
            employee.setDesignation(emp.get().getDesignation());
            employee.setName(emp.get().getName());
            employeeRepo.save(employee);
        }
        return salary;
    }
}
