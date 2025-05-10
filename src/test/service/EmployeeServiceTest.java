package com.nttdata.employee_management_ntt_data.service;

import com.nttdata.employee_management_ntt_data.model.Employee;
import com.nttdata.employee_management_ntt_data.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmployees_ShouldReturnAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John Doe", "123456789", "12345678", "Lima", "1990-01-01"));
        employees.add(new Employee(2L, "Jane Smith", "987654321", "87654321", "Arequipa", "1992-05-15"));

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void getEmployeeById_ShouldReturnEmployee_WhenExists() {
        Employee employee = new Employee(1L, "John Doe", "123456789", "12345678", "Lima", "1990-01-01");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.getEmployeeById(1L);

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void saveEmployee_ShouldSaveAndReturnEmployee() {
        Employee employee = new Employee(1L, "John Doe", "123456789", "12345678", "Lima", "1990-01-01");
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.saveEmployee(employee);

        assertEquals("John Doe", result.getName());
        verify(employeeRepository, times(1)).save(employee);
    }
}
