package retrieverStudyApi.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "study_group")
public class StudyGroup {
    @Id
    private String id;
    @NotBlank(message = "group name is required")
    private String GroupName;
    private String description;
    private List<String> memberIds;
    private LocalDateTime createdAt; 
}
