package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Registration createRegistration(Registration registration) {
        entityManager.persist(registration);
        return registration;
    }

    @Override
    public List<Registration> findAll() {
        List<Registration> registrations = entityManager.createNamedQuery(Registration.REGISTRATIONS).getResultList();
        return registrations;
    }

    @Override
    public List<RegistrationReport> findAllReports() {
        List<RegistrationReport> registrationReports = entityManager.createNamedQuery(Registration.REGISTRATION_REPORT).getResultList();
        return registrationReports;
    }
}
