package com.nttdata.employee_management_ntt_data.controller;

import com.nttdata.employee_management_ntt_data.model.Office;
import com.nttdata.employee_management_ntt_data.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    @GetMapping("/{id}")
    public Optional<Office> getOfficeById(@PathVariable Long id) {
        return officeService.getOfficeById(id);
    }

    @PostMapping
    public Office saveOffice(@RequestBody Office office) {
        return officeService.saveOffice(office);
    }

      @PutMapping("/{id}")
    public Office updateOffice(@PathVariable Long id, @RequestBody Office office) {
        Optional<Office> existingOffice = officeService.getOfficeById(id);
        if (existingOffice.isPresent()) {
            Office off = existingOffice.get();
            off.setName(office.getName());
            off.setAddress(office.getAddress());
            return officeService.saveOffice(off);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
    }
}
