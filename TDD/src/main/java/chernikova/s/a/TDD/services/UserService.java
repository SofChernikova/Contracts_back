package chernikova.s.a.TDD.services;

import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("")
        );
    }
}
