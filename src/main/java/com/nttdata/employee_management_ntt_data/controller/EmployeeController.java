package com.nttdata.employee_management_ntt_data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.nttdata.employee_management_ntt_data.dto.EmployeeDTO;
import com.nttdata.employee_management_ntt_data.model.Employee;
import com.nttdata.employee_management_ntt_data.model.Office;
import com.nttdata.employee_management_ntt_data.repository.OfficeRepository;
import com.nttdata.employee_management_ntt_data.service.EmployeeService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OfficeRepository officeRepository;

    @GetMapping
public List<EmployeeDTO> getAllEmployees() {
    return employeeService.getAllEmployees().stream()
            .map(EmployeeDTO::new)
            .collect(Collectors.toList());
}


  @GetMapping("/{id}")
public EmployeeDTO getEmployeeById(@PathVariable Long id) {
    Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);

    if (existingEmployee.isPresent()) {
        Employee employee = existingEmployee.get();
        return new EmployeeDTO(employee);
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
}
   


@PostMapping
public Employee saveEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
}

@PutMapping("/{id}")
public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployeeData) {
    Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);

    if (existingEmployee.isPresent()) {
        Employee employee = existingEmployee.get();

        employee.setName(updatedEmployeeData.getName());
        employee.setPhoneNumber(updatedEmployeeData.getPhoneNumber());
        employee.setDni(updatedEmployeeData.getDni());
        employee.setAddress(updatedEmployeeData.getAddress());
        employee.setBirthDate(updatedEmployeeData.getBirthDate());

        Employee updatedEmployee = employeeService.saveEmployee(employee);
        return new EmployeeDTO(updatedEmployee);
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
}


@PutMapping("/{id}/offices")
public EmployeeDTO updateEmployeeOffices(@PathVariable Long id, @RequestBody List<Long> officeIds) {
    Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);

    if (existingEmployee.isPresent()) {
        Employee employee = existingEmployee.get();

        List<Office> offices = officeRepository.findAllById(officeIds);
        employee.setOffices(new HashSet<>(offices));

        Employee updatedEmployee = employeeService.saveEmployee(employee);

        return new EmployeeDTO(updatedEmployee);
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
}



    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}