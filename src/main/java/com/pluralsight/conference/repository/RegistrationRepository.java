package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

import java.util.List;

public interface RegistrationRepository {
    Registration createRegistration(Registration registration);

    List<Registration> findAll();

    List<RegistrationReport> findAllReports();
}
