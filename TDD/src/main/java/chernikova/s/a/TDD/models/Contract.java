package chernikova.s.a.TDD.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "num", nullable = false, unique = true)
    private String num;

    @Column(name = "initiator", nullable = false)
    private String initiator;

    @Column(name = "defendant", nullable = false)
    private String defendant;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "conclusion_date", nullable = false)
    private LocalDate conclusionDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
