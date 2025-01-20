package retrieverStudyApi.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

import retrieverStudyApi.Entity.StudyGroup;
import retrieverStudyApi.Repository.StudyGroupRepository;

@Service
public class StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupService (StudyGroupRepository studyGroupRepository){
        this.studyGroupRepository = studyGroupRepository;
    }

    public StudyGroup createGroup(String groupName, String description){
        StudyGroup group = StudyGroup.builder()
            .GroupName(groupName)
            .description(description)
            .createdAt(LocalDateTime.now())
            .build();

        return studyGroupRepository.save(group);
    }

    public Optional <StudyGroup> findGroupById(String id){
        return studyGroupRepository.findById(id);

    }

}
