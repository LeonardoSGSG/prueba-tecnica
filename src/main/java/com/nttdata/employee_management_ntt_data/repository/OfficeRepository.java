package com.nttdata.employee_management_ntt_data.repository;

import com.nttdata.employee_management_ntt_data.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}