package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/{groupId}")
    public SimpleResponse saveStudent(@RequestBody StudentRequest studentRequest,
                                      @PathVariable Long groupId) {
        studentService.saveStudent(studentRequest, groupId);
        return new SimpleResponse(
                HttpStatus.OK,
                "Student successfully saved");
    }

    @GetMapping("/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public SimpleResponse updateStudent(@PathVariable Long studentId,
                                        @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentId,studentRequest);
    }
    @DeleteMapping("/{studentId}")
    public SimpleResponse deleteStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }

}
