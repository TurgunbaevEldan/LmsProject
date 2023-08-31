package peaksoft.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor findInstructorByFirstName(String name);
    @Query("select new peaksoft.dto.response.InstructorResponse(i.firstName,i.lastName,i.phoneNumber,i.specialization)from Instructor i")
    List<InstructorResponse>getAllInstructors();

    @Query("select new peaksoft.dto.response.InstructorResponse(i.id,i.firstName,i.lastName,i.phoneNumber,i.specialization)from Instructor i where i.id = :id")
    Optional<InstructorResponse>getInstructorById(Long id);
}
