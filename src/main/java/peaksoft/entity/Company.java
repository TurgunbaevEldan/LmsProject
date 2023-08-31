package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Company {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "companies_gen"
    )
    @SequenceGenerator(
            name = "companies_gen",
            sequenceName = "companies_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "company", cascade = ALL)
    private List<Course> courses;
    @ManyToMany(cascade = REFRESH)
    private List<Instructor> instructors;
}
