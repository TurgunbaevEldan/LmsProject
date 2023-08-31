package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_gen"
    )
    @SequenceGenerator(
            name = "students_gen",
            sequenceName = "students_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String studyFormat;
    @ManyToOne(cascade = REFRESH)
    private Group group;
}
