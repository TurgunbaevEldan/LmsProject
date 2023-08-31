package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {
    SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);
    List<LessonResponse> getAllLessons();

    LessonResponse getLessonById(Long lessonId);

    SimpleResponse updateLesson(Long lessonId, LessonRequest lessonRequest);

    SimpleResponse deleteLesson(Long lessonId);
}
