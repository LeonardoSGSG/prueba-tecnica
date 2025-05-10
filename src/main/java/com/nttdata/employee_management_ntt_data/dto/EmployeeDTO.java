package com.nttdata.employee_management_ntt_data.dto;

import com.nttdata.employee_management_ntt_data.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String dni;
    private String address;
    private String birthDate;
    private List<OfficeSummaryDTO> offices;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.phoneNumber = employee.getPhoneNumber();
        this.dni = employee.getDni();
        this.address = employee.getAddress();
        this.birthDate = employee.getBirthDate().toString();
        this.offices = employee.getOffices().stream()
                .map(office -> new OfficeSummaryDTO(
                        office.getId(),
                        office.getName(),
                        office.getAddress()
                ))
                .collect(Collectors.toList());
    }
}
