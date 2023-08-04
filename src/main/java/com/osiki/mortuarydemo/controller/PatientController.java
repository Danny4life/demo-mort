package com.osiki.mortuarydemo.controller;

import com.osiki.mortuarydemo.model.Patient;
import com.osiki.mortuarydemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        super();
        this.patientService = patientService;
    }

    @GetMapping("/patient")
    public String listProfile(Model model){
        model.addAttribute("patient", patientService.getAllPatients());

        return "patient";

    }


    @GetMapping("/patients/new")
    public String createPatientForm(Model model){
        Patient patient = new Patient();

        model.addAttribute("patient", patient);

        return "create_profile";
    }

    @PostMapping("/patient")
    public String savePatient(@ModelAttribute("patient") Patient patient){

        patientService.savePatient(patient);

        return "redirect:/patient";

    }

    @GetMapping("/{fileNumber}")
    @ResponseBody
    public ResponseEntity<Patient> getPatientByFileNumber(@PathVariable Long fileNumber) {
        Patient patient = patientService.getPatientByFileNumber(fileNumber);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

}
