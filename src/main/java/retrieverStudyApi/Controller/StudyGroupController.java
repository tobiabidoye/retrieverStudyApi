package retrieverStudyApi.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import retrieverStudyApi.Entity.StudyGroup;
import retrieverStudyApi.Service.StudyGroupService;

@RestController()
@RequestMapping("/groups")
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService){
        this.studyGroupService = studyGroupService;
    }

    @PostMapping("/create")
    //response entity of study group type to show group was indeed created
    public ResponseEntity<StudyGroup> createGroup(@RequestParam String groupName, @RequestParam String description){
        StudyGroup createdGroup = studyGroupService.createGroup(groupName, description);
        return ResponseEntity.ok(createdGroup);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroup> getGroup(@RequestParam String id){
        
        return studyGroupService.findGroupById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        

    }


    
}
