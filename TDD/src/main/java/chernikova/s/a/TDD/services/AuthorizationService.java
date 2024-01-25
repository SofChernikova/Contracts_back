package chernikova.s.a.TDD.services;

import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final UserRepository repository; //репозиторий зарегистрированных людей

    public User authorization(String email, String password){
        User user = repository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("Введена неправильная почта или Вы ещё не зарегистрированы")
        );
       if(!user.getPassword().equals(password))
           throw new IllegalArgumentException("Введен неправильный пароль");
       return user;
    }
}
