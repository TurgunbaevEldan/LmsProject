package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/inst")
@RequiredArgsConstructor
public class InstructorApi {
    private final InstructorService instructorService;

    @GetMapping
    public List<InstructorResponse> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping
    public SimpleResponse saveInstructors(@RequestBody InstructorRequest instructorRequest) {
        instructorService.saveInstructors(instructorRequest);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Instructors successfully saved")
                .build();
    }

    @GetMapping("/{instructorId}")
    public InstructorResponse getInstructorById(@PathVariable Long instructorId) {
        return instructorService.getInstructorById(instructorId);
    }

    @PutMapping("/{instructorId}")
    public SimpleResponse updateInstructors(@PathVariable Long instructorId,
                                            @RequestBody InstructorRequest instructorRequest) {
        return instructorService.updateInstructors(instructorId, instructorRequest);
    }

    @DeleteMapping("/{instructorsId}")
    public SimpleResponse deleteInstructors(@PathVariable Long instructorsId) {
        return instructorService.deleteInstructor(instructorsId);
    }

    @PostMapping("/{companyId}/{instructorId}")
    public SimpleResponse assignInstructorToCompany(@PathVariable Long companyId,
                                                    @PathVariable Long instructorId) {
        return instructorService.assignInstructorToCompany(companyId, instructorId);
    }
}
