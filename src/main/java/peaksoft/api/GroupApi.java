package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @GetMapping
    public List<GroupResponse> getAll() {
        return groupService.getAllGroups();
    }

    @PostMapping("/{courseId}/{groupId}")
    public SimpleResponse saveGroup(@RequestBody GroupRequest groupRequest,
                                    @PathVariable Long courseId,
                                    @PathVariable Long groupId) {
        groupService.saveGroup(groupRequest, courseId, groupId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Group successfully saved")
                .build();
    }

    @GetMapping("/{groupId}")
    public GroupResponse getGroupById(@PathVariable Long groupId) {
        return groupService.getGroupById(groupId);
    }
    @PutMapping("/{groupId}")
    public SimpleResponse updateGroup(@RequestBody GroupRequest groupRequest,
                                      @PathVariable Long groupId){
        return groupService.updateGroup(groupId,groupRequest);

    }
    @DeleteMapping("/{groupId}")
    public SimpleResponse deleteGroup(@PathVariable Long groupId){
        return groupService.deleteGroup(groupId);
    }
}