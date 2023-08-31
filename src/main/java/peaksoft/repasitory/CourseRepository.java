package peaksoft.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select new peaksoft.dto.response.CourseResponse (c.courseName,c.dateOfStart,c.description)from Course c")
    List<CourseResponse> getAllCourses();

    Optional<Course> getCourseById(Long aLong);
}
