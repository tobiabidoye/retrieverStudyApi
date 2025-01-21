package retrieverStudyApi.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import retrieverStudyApi.Entity.StudyGroup;

public interface StudyGroupRepository extends MongoRepository <StudyGroup,String> { 
    
}