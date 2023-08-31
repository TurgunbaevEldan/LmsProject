package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.repasitory.CourseRepository;
import peaksoft.repasitory.GroupRepository;
import peaksoft.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest, Long courseId, Long groupId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new NullPointerException(
                        "Course with id: %s is not found!".formatted(courseId)));
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NullPointerException(
                        "Group with id: %s is not found!".formatted(groupId)));
        group.getCourses().add(course);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group.setGroupName(groupRequest.getGroupName());
        group.setDescription(groupRequest.getDescription());
        group.setImageLing(groupRequest.getImageLing());
        group.setCourses(courses);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Group with id: %s successfully saved!".formatted(groupId))
                .build();
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        return groupRepository.getGroupById(id).orElseThrow(
                () -> new NullPointerException(
                        "Course with id " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updateGroup(Long groupId, GroupRequest groupRequest) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NullPointerException(
                        "Group with id: %s is not found".formatted(groupId)));
        group.setGroupName(groupRequest.getGroupName());
        group.setImageLing(groupRequest.getImageLing());
        group.setDescription(groupRequest.getDescription());
        groupRepository.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Group with id: %s successfully update".formatted(groupId))
                .build();
    }

    @Override
    public SimpleResponse deleteGroup(Long groupId) {
        if (!groupRepository.existsById(groupId)) {
            throw new NullPointerException(
                    "Group with id: " + groupId + " is not found!");
        }
        groupRepository.deleteById(groupId);
        return new SimpleResponse(
                HttpStatus.OK,
                "Group with id: %s successfully deleted".formatted(groupId));
    }
}