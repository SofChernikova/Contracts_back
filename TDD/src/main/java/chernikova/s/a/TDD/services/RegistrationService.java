package chernikova.s.a.TDD.services;

import chernikova.s.a.TDD.models.forms.RegistrationForm;
import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final CheckService checkService;

    public User registration(RegistrationForm form) {
        if (!checkService.checkCompany(form.getCompanyName(), form.getInn().toString(), form.getOgrn().toString()))
            throw new IllegalArgumentException("Компании нет в гос. реестре");

        if (!checkService.checkStaff(form.getCompanyName(), form.getSurname(), form.getName(), form.getLastname()))
            throw new IllegalArgumentException("В компании нет такого сотрудника");


        User user = User.builder()
                .companyName(form.getCompanyName())
                .INN(form.getInn())
                .OGRN(form.getOgrn())
                .name(form.getName())
                .surname(form.getSurname())
                .lastname(form.getLastname())
                .email(form.getEmail())
                .password(form.getPassword())
                .build();

        return userRepository.save(user);
    }
}
