package peaksoft.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select new peaksoft.dto.response.StudentResponse(s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat)from Student s")
    List<StudentResponse>getAllStudents();

    @Query("select new peaksoft.dto.response.StudentResponse(s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat)from Student s where s.id = :id")

    Optional<StudentResponse> getStudentById(Long id);
}
