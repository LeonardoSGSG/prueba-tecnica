package com.nttdata.employee_management_ntt_data.controller;

import com.nttdata.employee_management_ntt_data.dto.EmployeeDTO;
import com.nttdata.employee_management_ntt_data.model.Employee;
import com.nttdata.employee_management_ntt_data.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void getAllEmployees_ShouldReturnListOfEmployees() throws Exception {
        List<EmployeeDTO> employees = new ArrayList<>();
        employees.add(new EmployeeDTO(new Employee(1L, "John Doe", "123456789", "12345678", "Lima", "1990-01-01")));

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    void getEmployeeById_ShouldReturnEmployee_WhenExists() throws Exception {
        EmployeeDTO employee = new EmployeeDTO(new Employee(1L, "John Doe", "123456789", "12345678", "Lima", "1990-01-01"));

        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(employee.getEmployee()));

        mockMvc.perform(get("/api/employees/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }
}
