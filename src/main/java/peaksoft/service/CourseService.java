package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {
    SimpleResponse saveCourse(CourseRequest courseRequest, Long companyId);

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long id);

    SimpleResponse updateCourse(Long courseId, CourseRequest courseRequest);

    SimpleResponse deleteCourse(Long courseId);
}