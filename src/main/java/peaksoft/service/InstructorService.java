package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorResponse;

import java.util.List;

public interface InstructorService {
    SimpleResponse saveInstructors(InstructorRequest instructorRequest);
    List<InstructorResponse>getAllInstructors();
    InstructorResponse getInstructorById(Long id);
    SimpleResponse updateInstructors(Long instructorId, InstructorRequest instructorRequest);
    SimpleResponse deleteInstructor(Long instructorId);
    SimpleResponse assignInstructorToCompany(Long companyId, Long instructorId);
}
