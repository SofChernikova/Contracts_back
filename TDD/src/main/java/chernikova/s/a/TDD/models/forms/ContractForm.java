package chernikova.s.a.TDD.models.forms;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractForm {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String initiator;
    @NotNull
    @NotBlank
    private String defendant;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private String conclusionDate;
    @NotNull
    @NotBlank
    private String expirationDate;
}
