package chernikova.s.a.TDD.models.forms;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationFormTest {
    private AuthorizationForm form = AuthorizationForm.builder()
            .email("test@gmail.com")
            .password("Pa10!")
            .build();
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();
    private Set<ConstraintViolation<AuthorizationForm>> violations;
    private ConstraintViolation<AuthorizationForm> violation;

    @Test
    void Email() {
        form.setEmail("null");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("email must equals test@gmail.com", violation.getMessage());

        form.setEmail(null);
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("email must not be null", violation.getMessage());

        form.setEmail("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("email must not be blank", violation.getMessage());
    }

    @Test
    void Password() {
        form.setPassword("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("password must not be blank", violation.getMessage());
    }
}