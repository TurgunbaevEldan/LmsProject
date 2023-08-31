package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import static jakarta.persistence.CascadeType.*;

import java.util.List;
@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Lesson {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lessons_gen"
    )
    @SequenceGenerator(
            name = "lessons_gen",
            sequenceName = "lessons_seq",
            allocationSize = 1
    )
    private Long id;
    private String lessonName;
    @ManyToOne(cascade = REFRESH)
    private Course course;
    @OneToMany(mappedBy = "lesson",cascade = ALL)
    private List<Task>tasks;
}
