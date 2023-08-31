package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApi {
    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/{companyId}")
    public SimpleResponse saveCourse(@RequestBody CourseRequest courseRequest,
                                     @PathVariable Long companyId) {
        courseService.saveCourse(courseRequest, companyId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Course successfully saved")
                .build();
    }

    @GetMapping("/{courseId}")
    public CourseResponse getById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @PutMapping("/{courseId}")
    public SimpleResponse updateCourse(@PathVariable Long courseId,
                                       @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(courseId, courseRequest);

    }
    @DeleteMapping("/{courseId}")
    public SimpleResponse deleteCourse(@PathVariable Long courseId){
        return courseService.deleteCourse(courseId);
    }
}