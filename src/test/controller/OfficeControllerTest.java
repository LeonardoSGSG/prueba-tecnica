package com.nttdata.employee_management_ntt_data.controller;

import com.nttdata.employee_management_ntt_data.model.Office;
import com.nttdata.employee_management_ntt_data.service.OfficeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OfficeController.class)
class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfficeService officeService;

    @Test
    void getAllOffices_ShouldReturnListOfOffices() throws Exception {
        List<Office> offices = new ArrayList<>();
        offices.add(new Office(1L, "Office 1", "Address 1"));

        when(officeService.getAllOffices()).thenReturn(offices);

        mockMvc.perform(get("/api/offices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Office 1"));
    }
}
