package chernikova.s.a.TDD.models.forms;

import chernikova.s.a.TDD.models.forms.RegistrationForm;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationFormTest {
    private RegistrationForm form = RegistrationForm.builder()
            .companyName("Company 1")
            .inn("123456789012")
            .ogrn("1234567890123")
            .name("Andrey")
            .lastname("Andreevich")
            .surname("Andreev")
            .email("test@gmail.com")
            .password("Pa10!")
            .build();
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();
    private Set<ConstraintViolation<RegistrationForm>> violations;
    private ConstraintViolation<RegistrationForm> violation;
    @Test
    void companyName() {
        violations = validator.validate(form);
        assertTrue(violations.isEmpty());

        form.setCompanyName("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("companyName must not be blank", violation.getMessage());
    }
    @Test
    void INN() {
        form.setInn("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("INN must not be blank", violation.getMessage());

        form.setInn("1234");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("INN length must be from 12 to 12", violation.getMessage());
    }

    @Test
    void OGRN() {
        form.setOgrn("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("OGRN must not be blank", violation.getMessage());

        form.setOgrn("1234");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("OGRN length must be from 13 to 13", violation.getMessage());
    }

    @Test
    void Surname() {
        form.setSurname("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("surname must not be blank", violation.getMessage());
    }

    @Test
    void Name() {
        form.setName("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("name must not be blank", violation.getMessage());
    }

    @Test
    void Lastname() {
        form.setLastname("   ");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("lastname must not be blank", violation.getMessage());
    }

    @Test
    void Email() {
        form.setEmail("null");
        violations = validator.validate(form);
        violation = violations.iterator().next();
        assertEquals("email must equals test@gmail.com", violation.getMessage());

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