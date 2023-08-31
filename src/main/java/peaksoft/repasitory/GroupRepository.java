package peaksoft.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("select new peaksoft.dto.response.GroupResponse(g.groupName,g.imageLing,g.description)from Group g")
    List<GroupResponse>getAllGroups();

    @Query("select new peaksoft.dto.response.GroupResponse(g.groupName,g.imageLing,g.description)from Group g where g.id = :id")
    Optional<GroupResponse> getGroupById(Long id);
}
