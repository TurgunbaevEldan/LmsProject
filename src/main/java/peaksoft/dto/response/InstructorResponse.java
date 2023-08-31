package peaksoft.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.Company;
import peaksoft.entity.Course;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor


public class InstructorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;
    private List<Course> courses;
    private List<Company> companies;


    public InstructorResponse(Long id, String firstName, String lastName, String phoneNumber, String specialization, List<Course> courses, List<Company> companies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.courses = courses;
        this.companies = companies;
    }

    public InstructorResponse(Long id, String firstName, String lastName, String phoneNumber, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }

    public InstructorResponse(String firstName, String lastName, String phoneNumber, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
}
