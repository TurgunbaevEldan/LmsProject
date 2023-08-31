package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private List<Course> courses;
    private List<Instructor> instructors;



    public CompanyResponse(Long id, String name, String country, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
