package retrieverStudyApi.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
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
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    @Email(message = "invalid email address")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password is required") 
    private String password;
    private LocalDateTime createdAt;


}
