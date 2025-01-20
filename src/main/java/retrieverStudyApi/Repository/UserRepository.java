package retrieverStudyApi.Repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import retrieverStudyApi.Entity.User;


public interface UserRepository extends MongoRepository<User,String>{
   Optional<User> findByEmail(String email); 
}
