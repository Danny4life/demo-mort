package com.osiki.mortuarydemo.service.impl;

import com.osiki.mortuarydemo.model.Patient;
import com.osiki.mortuarydemo.repository.PatientRepository;
import com.osiki.mortuarydemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient getPatientByFileNumber(String fileNumber) {
        List<Patient> patients = new ArrayList<>();


        return patients.stream()
                .filter(patient -> patient.getFileNumber().equals(fileNumber))
                .findFirst()
                .orElse(null);
    }
}
