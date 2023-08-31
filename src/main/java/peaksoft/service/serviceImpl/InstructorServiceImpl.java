package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.entity.Company;
import peaksoft.entity.Instructor;
import peaksoft.repasitory.CompanyRepository;
import peaksoft.repasitory.InstructorRepository;
import peaksoft.service.InstructorService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;

    @Override
    public SimpleResponse saveInstructors(InstructorRequest instructorRequest) {
        Instructor instructor1 = new Instructor();
        instructor1.setFirstName(instructorRequest.getFirstName());
        instructor1.setLastName(instructorRequest.getLastName());
        instructor1.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor1.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor1);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Instructor with id: %s successfully saved", instructor1.getId()))
                .build();
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
    return instructorRepository.getAllInstructors();
    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id).orElseThrow(
                () -> new NullPointerException(
                        "Instructor with id: " + id + " is not found"));
    }

    @Override
    public SimpleResponse updateInstructors(Long instructorId, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
                () -> new NullPointerException(
                        "Instructor with id: %s is not found".formatted(instructorId)));
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Instructor with id: %s successfully update", instructor.getId()))
                .build();
    }

    @Override
    public SimpleResponse deleteInstructor(Long instructorId) {
        if (!instructorRepository.existsById(instructorId)) {
            throw new NullPointerException(
                    "Instructor id: " + instructorId + " is not found");
        }
        instructorRepository.deleteById(instructorId);
        return new SimpleResponse(
                HttpStatus.OK,
                "Instructor with id: " + instructorId + " successfully deleted");
    }

    @Override
    public SimpleResponse assignInstructorToCompany(Long companyId, Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
                () -> new NullPointerException("Instructor with id: %s " + instructorId + " is not found".formatted(instructorId)));
        Company company = companyRepository.findById(companyId).orElseThrow(
                () -> new NullPointerException(
                        "Company with id: %s " + companyId + " is not found".formatted(companyId)));

        company.getInstructors().add(instructor);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        instructor.setCompanies(companies);
        instructorRepository.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully instructor assign to company")
                .build();
    }

}

