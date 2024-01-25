package chernikova.s.a.TDD.models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationForm {
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "email must equals test@gmail.com")
    @NotBlank(message = "email must not be blank")
    @NotNull(message = "email must not be null")
    private String email;
    @NotBlank(message = "password must not be blank")
    @NotNull(message = "password must not be null")
    private String password;
}
