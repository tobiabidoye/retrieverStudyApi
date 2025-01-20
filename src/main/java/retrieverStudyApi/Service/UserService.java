package retrieverStudyApi.Service;

import java.time.LocalDateTime;


import org.springframework.stereotype.Service;

import retrieverStudyApi.Entity.User;
import retrieverStudyApi.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User RegisterUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already registered");
        }
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

}
