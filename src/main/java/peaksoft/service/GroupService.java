package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;

import java.util.List;
@Service
@Transactional

public interface GroupService {
    SimpleResponse saveGroup(GroupRequest groupRequest, Long courseId,Long groupId);
    List<GroupResponse>getAllGroups();
    GroupResponse getGroupById(Long id);
    SimpleResponse updateGroup(Long groupId, GroupRequest groupRequest);

    SimpleResponse deleteGroup(Long groupId);
}
