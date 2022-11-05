package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conference_registration")
@NamedQueries({
        @NamedQuery(name = Registration.REGISTRATIONS, query = Registration.REGISTRATIONS_JPQL),
        @NamedQuery(name = Registration.REGISTRATION_REPORT, query = Registration.REGISTRATION_REPORT_JPQL)
})
public class Registration {
    public static final String REGISTRATION_REPORT = "registrationReport";
    public static final String REGISTRATION_REPORT_JPQL =
            "Select new com.pluralsight.conference.model.RegistrationReport" +          "(r.name, c.name, c.description) " +
                    "from Registration r, Course c " +
                    "where r.id = c.registration.id";
    public static final String REGISTRATIONS = "registrations";
    public static final String REGISTRATIONS_JPQL =
            "Select r from Registration r";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<Course> course = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
