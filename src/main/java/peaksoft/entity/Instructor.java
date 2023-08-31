package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import static jakarta.persistence.CascadeType.*;

import java.util.List;
@Entity
@Table(name = "instructors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Instructor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructors_gen"
    )
    @SequenceGenerator(
            name = "instructors_gen",
            sequenceName = "instructors_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;

    @OneToMany(mappedBy = "instructor",cascade = REFRESH)
    private List<Course>courses;
    @ManyToMany(mappedBy = "instructors",cascade = REFRESH)
    private List<Company>companies;
}
