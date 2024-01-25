package chernikova.s.a.TDD.controllers;

import chernikova.s.a.TDD.models.forms.RegistrationForm;
import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.services.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping()
    public User registration(@Valid @RequestBody RegistrationForm form) {
        return registrationService.registration(form);
    }
}
