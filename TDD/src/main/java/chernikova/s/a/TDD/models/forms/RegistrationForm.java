package chernikova.s.a.TDD.models.forms;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
    @NotBlank(message = "companyName must not be blank")
    @NotNull(message = "companyName must not be null")
    private String companyName;
    @Length(min = 12, max = 12, message = "INN length must be from 12 to 12")
    @NotBlank(message = "INN must not be blank")
    @NotNull(message = "INN must not be null")
    private String inn;
    @Length(min = 13, max = 13, message = "OGRN length must be from 13 to 13")
    @NotBlank(message = "OGRN must not be blank")
    @NotNull(message = "OGRN must not be null")
    private String ogrn;
    @NotBlank(message = "surname must not be blank")
    @NotNull(message = "surname must not be null")
    private String surname;
    @NotBlank(message = "name must not be blank")
    @NotNull(message = "name must not be null")
    private String name;
    @NotBlank(message = "lastname must not be blank")
    @NotNull(message = "lastname must not be null")
    private String lastname;
    @NotBlank(message = "email must not be blank")
    @NotNull(message = "email must not be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
    message = "email must equals test@gmail.com")
    private String email;
    @NotBlank(message = "password must not be blank")
    @NotNull(message = "password must not be null")
    private String password;
}
