package chernikova.s.a.TDD.controllers;


import chernikova.s.a.TDD.models.User;
import chernikova.s.a.TDD.models.forms.AuthorizationForm;
import chernikova.s.a.TDD.services.AuthorizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorization")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @PostMapping()
    public User authorization(@Valid @RequestBody AuthorizationForm form) {
        return service.authorization(form.getEmail(), form.getPassword());
    }
}
