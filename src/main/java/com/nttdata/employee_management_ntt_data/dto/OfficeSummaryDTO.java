package com.nttdata.employee_management_ntt_data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OfficeSummaryDTO {
    private Long id;
    private String name;
    private String address;
}
