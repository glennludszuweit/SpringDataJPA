package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

import java.util.List;

public interface RegistrationService {
    Registration save(Registration registration);

    List<Registration> findAll();

    List<RegistrationReport> findAllReports();
}
