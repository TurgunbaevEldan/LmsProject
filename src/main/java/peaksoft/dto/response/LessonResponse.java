package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.Course;
import peaksoft.entity.Task;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponse {

    private Long id;
    private String lessonName;
    private Course course;
    private List<Task> tasks;

    public LessonResponse(String lessonName) {
        this.lessonName = lessonName;
    }
}
