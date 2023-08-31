package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    SimpleResponse saveStudent(StudentRequest studentRequest,Long groupId);
    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    SimpleResponse updateStudent(Long studentId, StudentRequest studentRequest);

    SimpleResponse deleteStudent(Long studentId);
}
