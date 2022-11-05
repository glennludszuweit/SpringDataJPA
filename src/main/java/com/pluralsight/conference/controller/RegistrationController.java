package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                  Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        } else {
            registrationService.save(registration);
        }

        System.out.println("Registration: " + registration.getName());

        return "redirect:registration";
    }

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {
        return "registration";
    }

    @GetMapping("registrations")
    public @ResponseBody List<Registration> getRegistrations() {
        List<Registration> registrations = registrationService.findAll();
        return registrations;
    }

    @GetMapping("registration-reports")
    public @ResponseBody List<RegistrationReport> getRegistrationReports() {
        List<RegistrationReport> registrationReports = registrationService.findAllReports();
        return registrationReports;
    }

    @PostMapping("registration/update")
    public @ResponseBody Registration updateRegistration(@Valid @ModelAttribute("registration") Registration registration, BindingResult binding) {
        return registrationService.save(registration);
    }
}
