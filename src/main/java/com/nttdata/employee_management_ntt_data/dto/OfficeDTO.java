package com.nttdata.employee_management_ntt_data.dto;

import com.nttdata.employee_management_ntt_data.model.Office;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class OfficeDTO {
    private Long id;
    private String name;
    private String address;
    private List<EmployeeDTO> employees;

    public OfficeDTO(Office office) {
        this.id = office.getId();
        this.name = office.getName();
        this.address = office.getAddress();
        this.employees = office.getEmployees()
                               .stream()
                               .map(EmployeeDTO::new)
                               .collect(Collectors.toList());
    }
}
