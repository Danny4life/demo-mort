package com.osiki.mortuarydemo.service;

import com.osiki.mortuarydemo.model.Patient;

import java.util.List;

public interface PatientService {


    List<Patient> getAllPatients();

    Patient savePatient(Patient patient);

    Patient getPatientById(Long id);
    Patient getPatientByFileNumber(Long fileNumber);
}
