package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import static jakarta.persistence.CascadeType.*;
import java.time.LocalDate;
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tasks_gen"
    )
    @SequenceGenerator(
            name = "tasks_gen",
            sequenceName = "tasks_seq",
            allocationSize = 1
    )
    private Long id;
    private String taskName;
    private String taskText;
    private LocalDate deadLine;
    @ManyToOne(cascade = REFRESH)
    private Lesson lesson;
}
