package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.dto.response.CourseResponse;

import java.time.LocalDate;
import java.util.List;
import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Course extends CourseResponse {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courses_gen"
    )
    @SequenceGenerator(
            name = "courses_gen",
            sequenceName = "courses_seq",
            allocationSize = 1
    )
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;
    @ManyToMany(mappedBy = "courses",cascade = REFRESH)
    private List<Group> groups;
    @OneToMany(mappedBy = "course",cascade = ALL)
    private List<Lesson>lessons;
    @ManyToOne(cascade = REFRESH)
    private Instructor instructor;
    @ManyToOne(cascade = REFRESH)
    private Company company;

}
