package com.nttdata.employee_management_ntt_data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.nttdata.employee_management_ntt_data.model.Employee;
import com.nttdata.employee_management_ntt_data.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
    if (existingEmployee.isPresent()) {
        Employee emp = existingEmployee.get();
        emp.setName(employee.getName() != null ? employee.getName() : emp.getName());
        emp.setPhoneNumber(employee.getPhoneNumber() != null ? employee.getPhoneNumber() : emp.getPhoneNumber());
        emp.setDni(employee.getDni() != null ? employee.getDni() : emp.getDni());
        emp.setAddress(employee.getAddress() != null ? employee.getAddress() : emp.getAddress());
        emp.setBirthDate(employee.getBirthDate() != null ? employee.getBirthDate() : emp.getBirthDate());

        return employeeService.saveEmployee(emp);
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
}


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}