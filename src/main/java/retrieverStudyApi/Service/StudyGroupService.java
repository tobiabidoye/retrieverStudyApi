package retrieverStudyApi.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import retrieverStudyApi.Entity.StudyGroup;
import retrieverStudyApi.Repository.StudyGroupRepository;
import java.util.List;
@Service
public class StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupService (StudyGroupRepository studyGroupRepository){
        this.studyGroupRepository = studyGroupRepository;
    }

    public StudyGroup createGroup(String groupName, String description){
        if(StringUtils.isBlank(groupName)){
           throw new IllegalArgumentException("Group Name must not be set to empty"); 
        }
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



    public List <StudyGroup> findAllGroups(){
        return studyGroupRepository.findAll();
    }

    public StudyGroup updateGroup(String id, String groupname, String newDescription){
        StudyGroup group = studyGroupRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Group not found with that ID"));

        if(!StringUtils.isBlank(groupname)){
            group.setGroupName(groupname);
        }

        if(!StringUtils.isBlank(newDescription)){
            group.setDescription(newDescription);
        }

        return studyGroupRepository.save(group);

    }

    public void deleteGroup(String id){
        if(!studyGroupRepository.existsById(id)){
            throw new IllegalArgumentException("no group exists with this id");
        }
        studyGroupRepository.deleteById(id);
    }
}
