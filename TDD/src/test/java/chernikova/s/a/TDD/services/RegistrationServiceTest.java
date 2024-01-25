package chernikova.s.a.TDD.services;

import chernikova.s.a.TDD.models.forms.RegistrationForm;
import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.repos.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RegistrationServiceTest {

    private CheckService checkService = mock(CheckService.class);
    private UserRepository userRepository = mock(UserRepository.class);
    private RegistrationService registrationService = new RegistrationService(userRepository,
            checkService);

    @Test
    void registration() {
        User user = mock(User.class);
        RegistrationForm form = mock(RegistrationForm.class);

        when(userRepository.save(any(User.class))).thenReturn(user);

        when(checkService.checkCompany(form.getCompanyName(), form.getInn(), form.getOgrn())).thenReturn(true);
        when(checkService.checkStaff(form.getCompanyName(), form.getSurname(), form.getName(), form.getLastname()))
                .thenReturn(true);
        assertEquals(user, registrationService.registration(form));

        when(checkService.checkCompany(form.getCompanyName(), form.getInn(), form.getOgrn())).thenReturn(false);
        when(checkService.checkStaff(form.getCompanyName(), form.getSurname(), form.getName(), form.getLastname()))
                .thenReturn(true);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registrationService.registration(form);
        });
        assertEquals("Компании нет в гос. реестре", exception.getMessage());

        when(checkService.checkCompany(form.getCompanyName(), form.getInn(), form.getOgrn())).thenReturn(true);
        when(checkService.checkStaff(form.getCompanyName(), form.getSurname(), form.getName(), form.getLastname()))
                .thenReturn(false);
        exception = assertThrows(IllegalArgumentException.class, () -> {
            registrationService.registration(form);
        });
        assertEquals("В компании нет такого сотрудника", exception.getMessage());
    }
}