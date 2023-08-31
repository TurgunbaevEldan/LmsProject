package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.Company;
import peaksoft.entity.Group;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CourseResponse {
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;
    private List<Group> groups;
    private List<Lesson>lessons;
    private Instructor instructor;
    private Company company;



    public CourseResponse(String courseName, LocalDate dateOfStart, String description) {
        this.courseName = courseName;
        this.dateOfStart = dateOfStart;
        this.description = description;
    }
}


