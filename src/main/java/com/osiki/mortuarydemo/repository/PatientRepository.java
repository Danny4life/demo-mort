package com.osiki.mortuarydemo.repository;

import com.osiki.mortuarydemo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
