package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import static jakarta.persistence.CascadeType.*;

import java.util.List;
@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Group {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groups_gen"
    )
    @SequenceGenerator(
            name = "groups_gen",
            sequenceName = "groups_seq",
            allocationSize = 1
    )
    private Long id;
    private String groupName;
    private String imageLing;
    private String description;
    @ManyToMany(cascade = REFRESH)
    private List<Course>courses;
    @OneToMany(mappedBy = "group",cascade = ALL)
    private List<Student>students;
}
