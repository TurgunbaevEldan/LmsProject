package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repasitory.CompanyRepository;
import peaksoft.repasitory.CourseRepository;
import peaksoft.service.CourseService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @Override
    public SimpleResponse saveCourse(CourseRequest courseRequest, Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(
                () -> new NullPointerException(("Company with id %s is not found!".formatted(companyId))
                ));
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        course.setCompany(company);
        courseRepository.save(course);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Course with id: %s successfully saved!", course.getId()))
                .build();
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        return courseRepository.getCourseById(id).orElseThrow(
                () -> new NullPointerException(
                        "Course with id " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updateCourse(Long courseId, CourseRequest courseRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(()
                -> new NullPointerException("Course with id %s is not found!".formatted(courseId)));
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);

        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Course with id: %s successfully updated!", course.getId()))
                .build();
    }

    @Override
    public SimpleResponse deleteCourse(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new NullPointerException(
                    "Course with id: " + courseId + " is not found!");
        }
        companyRepository.deleteById(courseId);
        return new SimpleResponse(
                HttpStatus.OK,
                "Course with id: " + courseId + " successfully deleted"
        );
    }
}