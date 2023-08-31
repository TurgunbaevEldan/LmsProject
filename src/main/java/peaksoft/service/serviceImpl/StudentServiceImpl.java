package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.repasitory.GroupRepository;
import peaksoft.repasitory.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest, Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NullPointerException(
                        "Group with id: %s is not found!".formatted(groupId)));
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setGroup(group);
        studentRepository.save(student);
        return new SimpleResponse(
                HttpStatus.OK,
                "Student successfully saved");
}

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentRepository.getStudentById(id).orElseThrow(
                () -> new NullPointerException(
                        "Student with id: %s is not found!".formatted(id)));
    }

    @Override
    public SimpleResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new NullPointerException(
                        "Student with id: %s is not found".formatted(studentId)));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        studentRepository.save(student);
        return new SimpleResponse(
                HttpStatus.OK,
                "Student with id: %s successfully updated".formatted(studentId));
    }

    @Override
    public SimpleResponse deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            throw new NullPointerException(
                    "Student with id: %s is not found".formatted(studentId));
        }
        studentRepository.deleteById(studentId);
        return new SimpleResponse(
                HttpStatus.OK,
                "Student with id: %s successfully deleted".formatted(studentId));
    }
}
