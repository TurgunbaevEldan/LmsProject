package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;
import peaksoft.service.LessonService;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonApi {
    private final LessonService lessonService;

    @GetMapping
    public List<LessonResponse> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PostMapping("/{courseId}")
    public SimpleResponse saveLesson(@PathVariable Long courseId,
            @RequestBody LessonRequest lessonRequest
                                     ) {
       return lessonService.saveLesson(courseId,lessonRequest);

    }

    @GetMapping("/{lessonId}")
    LessonResponse getLessonById(@PathVariable Long lessonId){
        return lessonService.getLessonById(lessonId);
    }

    @PutMapping("/{lessonId}")
    public SimpleResponse updateLesson(@RequestBody LessonRequest lessonRequest,
                                       @PathVariable Long lessonId){
        return lessonService.updateLesson(lessonId,lessonRequest);
    }
    @DeleteMapping("/{lessonId}")
    public SimpleResponse deleteLesson(@PathVariable Long lessonId){
        return lessonService.deleteLesson(lessonId);
    }

}