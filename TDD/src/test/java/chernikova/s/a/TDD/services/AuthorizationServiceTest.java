package chernikova.s.a.TDD.services;

import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.models.forms.AuthorizationForm;
import chernikova.s.a.TDD.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class AuthorizationServiceTest {
    private AuthorizationForm form = AuthorizationForm.builder()
            .email("test@gmail.com")
            .password("Pa10!")
            .build();

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private AuthorizationService authorizationService = new AuthorizationService(userRepository);

    @Test
    void authorization() {
        User user = User.builder()
                .email("test@cmp.com")
                .password("Pa10!")
                .build();
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(user));

        assertEquals(user, authorizationService.authorization(form.getEmail(), form.getPassword()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            authorizationService.authorization(form.getEmail(), "Pa12!");
        });
        assertEquals("Введен неправильный пароль", exception.getMessage());

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            authorizationService.authorization("email", "Pa12!");
        });
        assertEquals("Введена неправильная почта или Вы ещё не зарегистрированы", exception.getMessage());
    }
}