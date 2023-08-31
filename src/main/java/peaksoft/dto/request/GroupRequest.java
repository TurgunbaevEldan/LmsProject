package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequest {
    private String groupName;
    private String imageLing;
    private String description;

    public GroupRequest(String groupName, String imageLing, String description) {
        this.groupName = groupName;
        this.imageLing = imageLing;
        this.description = description;
    }
}
