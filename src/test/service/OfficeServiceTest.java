package com.nttdata.employee_management_ntt_data.service;

import com.nttdata.employee_management_ntt_data.model.Office;
import com.nttdata.employee_management_ntt_data.repository.OfficeRepository;
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

class OfficeServiceTest {

    @Mock
    private OfficeRepository officeRepository;

    @InjectMocks
    private OfficeService officeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllOffices_ShouldReturnAllOffices() {
        List<Office> offices = new ArrayList<>();
        offices.add(new Office(1L, "Office 1", "Address 1"));
        offices.add(new Office(2L, "Office 2", "Address 2"));

        when(officeRepository.findAll()).thenReturn(offices);

        List<Office> result = officeService.getAllOffices();

        assertEquals(2, result.size());
        verify(officeRepository, times(1)).findAll();
    }

    @Test
    void getOfficeById_ShouldReturnOffice_WhenExists() {
        Office office = new Office(1L, "Office 1", "Address 1");
        when(officeRepository.findById(1L)).thenReturn(Optional.of(office));

        Optional<Office> result = officeService.getOfficeById(1L);

        assertTrue(result.isPresent());
        assertEquals("Office 1", result.get().getName());
        verify(officeRepository, times(1)).findById(1L);
    }

    @Test
    void saveOffice_ShouldSaveAndReturnOffice() {
        Office office = new Office(1L, "Office 1", "Address 1");
        when(officeRepository.save(office)).thenReturn(office);

        Office result = officeService.saveOffice(office);

        assertEquals("Office 1", result.getName());
        verify(officeRepository, times(1)).save(office);
    }
}
