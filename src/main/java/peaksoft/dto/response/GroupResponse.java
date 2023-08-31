package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.Course;
import peaksoft.entity.Student;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {
    private Long id;
    private String groupName;
    private String imageLing;
    private String description;
    private List<Course> courses;
    private List<Student> students;

    public GroupResponse(Long id, String groupName, String imageLing, String description) {
        this.id = id;
        this.groupName = groupName;
        this.imageLing = imageLing;
        this.description = description;
    }

    public GroupResponse(String groupName, String imageLing, String description) {
        this.groupName = groupName;
        this.imageLing = imageLing;
        this.description = description;
    }
}
