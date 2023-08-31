package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String studyFormat;

    public StudentRequest(String firstName, String lastName, String phoneNumber, String email, String studyFormat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
    }
}
