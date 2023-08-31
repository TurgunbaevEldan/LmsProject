package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repasitory.CourseRepository;
import peaksoft.repasitory.LessonRepository;
import peaksoft.service.LessonService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new NullPointerException(
                        "Course with id: %s is not found!".formatted(courseId)));
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return new SimpleResponse(
                HttpStatus.OK,
                "Lesson successfully saved!");
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    @Override
    public LessonResponse getLessonById(Long lessonId) {
        return lessonRepository.getLessonById(lessonId).orElseThrow(
                () -> new NullPointerException(
                        "Lesson with id: %s is not found".formatted(lessonId)));
    }

    @Override
    public SimpleResponse updateLesson(Long lessonId, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(
                () -> new NullPointerException(
                        "Lesson with id: %s is not found!".formatted(lessonId)));
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepository.save(lesson);
        return new SimpleResponse(
                HttpStatus.OK,
                "Lesson with id: %s successfully update".formatted(lessonId));
    }

    @Override
    public SimpleResponse deleteLesson(Long lessonId) {
        if (lessonRepository.existsById(lessonId)) {
            throw new NullPointerException(
                    "Lesson with id: %s is not found".formatted(lessonId));
        }
        lessonRepository.deleteById(lessonId);
        return new SimpleResponse(
                HttpStatus.OK,
                "lesson with id: %s successfully deleted".formatted(lessonId));
    }
}
