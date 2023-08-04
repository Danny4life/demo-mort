package com.osiki.mortuarydemo.controller;

import com.osiki.mortuarydemo.model.Body;
import com.osiki.mortuarydemo.model.Patient;
import com.osiki.mortuarydemo.repository.PatientRepository;
import com.osiki.mortuarydemo.service.BodyService;
import com.osiki.mortuarydemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BodyController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private BodyService bodyService;

    public BodyController(PatientService patientService, BodyService bodyService) {
        super();
        this.patientService = patientService;

        this.bodyService = bodyService;
    }


//    @GetMapping("/body")
//    public String listBody(Model model){
//        model.addAttribute("body", bodyService.getAllBodies());
//
//        return "body";
//
//    }

    @GetMapping("/body")
    public String showBodyForm(Model model){

        model.addAttribute("body", new Body());

        return "body";

    }

    @PostMapping("/body")
    public String saveBody(@ModelAttribute("body") Body body){

        bodyService.saveBody(body);

        return "redirect:/body";
    }

    @GetMapping("/getPatientInfo")
    public String getPatientInfo(@RequestParam("fileNumber") Long fileNumber, Model model){
        Patient patient = patientRepository.findById(fileNumber).orElse(null);

        if(patient != null){
            model.addAttribute("patient", patient);
            return  "patient_info";

        }else {
            return "redirect:/body";
        }

    }
}
