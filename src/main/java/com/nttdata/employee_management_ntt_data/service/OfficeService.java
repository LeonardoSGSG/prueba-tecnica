package com.nttdata.employee_management_ntt_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.employee_management_ntt_data.model.Office;
import com.nttdata.employee_management_ntt_data.repository.OfficeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Optional<Office> getOfficeById(Long id) {
        return officeRepository.findById(id);
    }

    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}
